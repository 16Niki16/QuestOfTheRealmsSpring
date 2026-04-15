package sofia.sap.interview.project.game.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import sofia.sap.interview.project.game.dto.loadgame.LoadedSessionInformation;
import sofia.sap.interview.project.game.dto.data.GameData;
import sofia.sap.interview.project.game.exceptions.LoadGameException;
import sofia.sap.interview.project.game.user.User;

import java.io.IOException;
import java.nio.file.Path;

public class LoadGameService {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public LoadedSessionInformation load(User user, String filename) {
        Path path = Path.of("files", user.getUsername(), filename);

        try {
            GameData data = MAPPER.readValue(path.toFile(), GameData.class);
            return LoadedSessionInformation.load(data);

        } catch (IOException e) {
            throw new LoadGameException("Failed to load game!", e);
        }
    }
}
