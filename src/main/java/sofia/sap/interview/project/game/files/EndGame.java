package sofia.sap.interview.project.game.files;

import sofia.sap.interview.project.game.exceptions.EndGameFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EndGame {

    public static void endGame(String username) {
        Path path = Path.of("files", username + ".json");

        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new EndGameFileException("Problem in end game file delete!", e);
        }
    }
}
