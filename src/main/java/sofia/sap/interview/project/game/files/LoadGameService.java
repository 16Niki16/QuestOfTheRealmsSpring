package sofia.sap.interview.project.game.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.dto.data.GameData;
import sofia.sap.interview.project.game.dto.loadgame.GameSessionFactory;
import sofia.sap.interview.project.game.exceptions.LoadGameException;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.user.User;

import java.io.IOException;
import java.nio.file.Path;

@Service
@AllArgsConstructor
public class LoadGameService {
    private final ObjectMapper mapper;
    private final PathResolver pathResolver;

    public GameSession load(User user, String filename) {
        Path path = pathResolver.userFile(user, filename);

        try {
            GameData data = mapper.readValue(path.toFile(), GameData.class);
            return GameSessionFactory.createGameSession(data);

        } catch (IOException e) {
            throw new LoadGameException("Failed to load game!", e);
        }
    }
}
