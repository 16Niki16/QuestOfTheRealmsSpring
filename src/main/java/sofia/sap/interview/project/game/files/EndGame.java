package sofia.sap.interview.project.game.files;

import sofia.sap.interview.project.game.exceptions.EndGameFileException;
import sofia.sap.interview.project.game.user.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EndGame {

    public static void endGame(User user, String filename) {
        Path path = Path.of("files", user.getUsername(), filename);

        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new EndGameFileException("Problem in end game file delete!", e);
        }
    }
}
