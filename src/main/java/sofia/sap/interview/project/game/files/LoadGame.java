package sofia.sap.interview.project.game.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import sofia.sap.interview.project.game.dto.loadgame.LoadedInformation;
import sofia.sap.interview.project.game.dto.savegame.data.GameData;
import sofia.sap.interview.project.game.exceptions.LoadGameException;
import sofia.sap.interview.project.game.user.User;

import java.io.IOException;
import java.nio.file.Path;

public class LoadGame {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static LoadedInformation load(User user, String filename) {
        Path path = Path.of("files", user.getUsername(), filename);

        try {
            GameData data = MAPPER.readValue(path.toFile(), GameData.class);
            return LoadedInformation.load(data);

        } catch (IOException e) {
            throw new LoadGameException("Failed to load game!", e);
        }
    }
}
