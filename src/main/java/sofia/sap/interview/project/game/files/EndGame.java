package sofia.sap.interview.project.game.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import sofia.sap.interview.project.game.exceptions.EndGameFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EndGame {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void endGame(String username) {
        try {
            Path path = Path.of("files", username + ".json");
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new EndGameFileException("Problem in end game file delete!", e);
        }
    }
}
