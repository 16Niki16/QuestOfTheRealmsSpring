package sofia.sap.interview.project.game.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.dto.savegame.GameDataFactory;
import sofia.sap.interview.project.game.exceptions.SaveGameException;
import sofia.sap.interview.project.game.user.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@AllArgsConstructor
public class SaveGameService {
    private final ObjectMapper mapper;

    public void saveGame(User user) {
        Path path = Path.of("files", user.getUsername(), user.getCurrentGameSessionName() + ".json");

        try {
            Files.createDirectories(path.getParent());
            mapper.writeValue(path.toFile(), GameDataFactory.save(user.getSession(), user.getLog()));
        } catch (IOException e) {
            throw new SaveGameException("Failed to auto save game", e);
        }
    }
}
