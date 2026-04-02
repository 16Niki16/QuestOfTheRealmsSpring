package sofia.sap.interview.project.game.files;

import sofia.sap.interview.project.game.user.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class GameName {

    public static String newGameName(User user) {
        int saveNumber = getNextSaveNumber(user.getUsername());

        return user.getUsername() + "_" + saveNumber;
    }

    private static int getNextSaveNumber(String username) {
        Path userDirectory = Path.of("files", username);

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
