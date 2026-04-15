package sofia.sap.interview.project.game.files;

import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.exceptions.EndGameFileException;
import sofia.sap.interview.project.game.exceptions.LoadGameException;
import sofia.sap.interview.project.game.user.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FileOperationsService {
    private static final String BASE = "files";

    public void deleteGame(User user) {
        Path path = Path.of(BASE, user.getUsername(), user.getCurrentGameSessionName());

        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new EndGameFileException("Problem in end game file delete!", e);
        }
    }

    public List<String> getSavedFiles(User user) {
        Path dir = Path.of(BASE, user.getUsername());

        if (!Files.exists(dir)) {
            throw new LoadGameException("No saved games found!");
        }

        try (Stream<Path> files = Files.list(dir)) {
            return files
                    .map(p -> p.getFileName().toString())
                    .sorted()
                    .toList();
        } catch (IOException e) {
            throw new LoadGameException("Could not extract the file names of the saved games!");
        }
    }

    public String getNewGameName(User user) {
        int saveNumber = getNextSaveNumber(user.getUsername());

        return user.getUsername() + "_" + saveNumber;
    }

    private int getNextSaveNumber(String username) {
        Path userDirectory = Path.of(BASE, username);

        if (!Files.exists(userDirectory)) {
            return 1;
        }

        try (Stream<Path> files = Files.list(userDirectory)) {

            return files
                    .map(p -> p.getFileName().toString())
                    .map(name -> name.replace(username + "_", "").replace(".json", ""))
                    .mapToInt(Integer::parseInt)
                    .max()
                    .orElse(0) + 1;
        } catch (IOException e) {
            return 1;
        }
    }
}
