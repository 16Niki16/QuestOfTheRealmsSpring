package sofia.sap.interview.project.game.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import sofia.sap.interview.project.game.dto.savegame.factory.GameDataFactory;
import sofia.sap.interview.project.game.user.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SaveGame {
    private static final ObjectMapper MAPPER =
        new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static void saveGame(User user) {

        MAPPER.enable(SerializationFeature.INDENT_OUTPUT);

        Path path = Path.of("files", user.getUsername() + ".json");
        try {
            Files.createDirectories(path.getParent());
            MAPPER.writeValue(path.toFile(), GameDataFactory.save(user.getSession(), user.getLog()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
