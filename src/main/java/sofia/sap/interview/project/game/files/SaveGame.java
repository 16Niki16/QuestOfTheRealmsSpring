package sofia.sap.interview.project.game.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import sofia.sap.interview.project.game.dto.savegame.factory.GameDataFactory;
import sofia.sap.interview.project.game.exceptions.SaveGameException;
import sofia.sap.interview.project.game.user.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class SaveGame {
    private static final ObjectMapper MAPPER = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static String saveGame(User user) {
        int saveNumber = getNextSaveNumber(user.getUsername());
        String filename = user.getUsername() + "_" + saveNumber + ".json";
        Path path = Path.of("files", user.getUsername(), filename);

        try {
            Files.createDirectories(path.getParent());
            MAPPER.writeValue(path.toFile(), GameDataFactory.save(user.getSession(), user.getLog()));
        } catch (IOException e) {
            throw new SaveGameException("Failed to save game", e);
        }

        return filename;
    }

    private static int getNextSaveNumber(String username) {
        Path dir = Path.of("files", username);

        if (!Files.exists(dir)) {
            return 1;
        }

        try (Stream<Path> files = Files.list(dir)) {

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
