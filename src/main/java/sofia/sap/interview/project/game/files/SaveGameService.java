package sofia.sap.interview.project.game.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.dto.savegame.GameDataFactory;
import sofia.sap.interview.project.game.exceptions.SaveGameException;
import sofia.sap.interview.project.game.user.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class SaveGameService {
    private static final ObjectMapper MAPPER = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public void saveGame(User user) {
        Path path = Path.of("files", user.getUsername(), user.getCurrentGameSessionName() + ".json");

        try {
            Files.createDirectories(path.getParent());
            MAPPER.writeValue(path.toFile(), GameDataFactory.save(user.getSession(), user.getLog()));
        } catch (IOException e) {
            throw new SaveGameException("Failed to auto save game", e);
        }
    }
}
