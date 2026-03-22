package sofia.sap.interview.project.game.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import sofia.sap.interview.project.game.dto.loadgame.LoadedInformation;
import sofia.sap.interview.project.game.dto.savegame.data.GameData;
import sofia.sap.interview.project.game.exceptions.LoadGameException;

import java.io.IOException;
import java.nio.file.Path;

public class LoadGame {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static LoadedInformation load(String username) {
        Path path = Path.of("files", username + ".json");

        try {
            GameData data = MAPPER.readValue(path.toFile(), GameData.class);
            return LoadedInformation.load(data);

        } catch (IOException e) {
            throw new LoadGameException("Failed to load game!", e);
        }
    }
}
