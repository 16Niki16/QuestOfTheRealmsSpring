package sofia.sap.interview.project.game.files;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.exceptions.EndGameFileException;
import sofia.sap.interview.project.game.exceptions.LoadGameException;
import sofia.sap.interview.project.game.user.User;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.Files.deleteIfExists;
import static java.nio.file.Files.exists;
import static java.nio.file.Files.list;

@Service
@AllArgsConstructor
public class GameFileService {
    private PathResolver pathResolver;

    public void deleteGame(User user, String filename) {
        Path path = pathResolver.userFile(user, filename);

        try {
            deleteIfExists(path);
        } catch (IOException e) {
            throw new EndGameFileException("Problem in end game file delete!", e);
        }
    }

    public List<String> getSavedFiles(User user) {
        Path dir = pathResolver.userDir(user);

        if (!exists(dir)) {
            throw new LoadGameException("No saved games found!");
        }

        try (Stream<Path> files = list(dir)) {
            return files
                    .map(p -> p.getFileName().toString())
                    .map(name -> name.replace(".json", ""))
                    .sorted()
                    .toList();
        } catch (IOException e) {
            throw new LoadGameException("Could not extract the file names of the saved games!");
        }
    }

    public String getNewGameName(User user) {
        int saveNumber = getNextSaveNumber(user);

        return user.getUsername() + "_" + saveNumber;
    }

    private int getNextSaveNumber(User user) {
        Path userDirectory = pathResolver.userDir(user);

        if (!exists(userDirectory)) {
            return 1;
        }

        try (Stream<Path> files = list(userDirectory)) {

            return files
                    .map(p -> p.getFileName().toString())
                    .map(name -> name.replace(user.getUsername() + "_", "").replace(".json", ""))
                    .mapToInt(Integer::parseInt)
                    .max()
                    .orElse(0) + 1;
        } catch (IOException e) {
            return 1;
        }
    }
}
