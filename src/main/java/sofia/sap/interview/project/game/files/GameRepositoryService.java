package sofia.sap.interview.project.game.files;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@Service
@AllArgsConstructor
public class GameRepositoryService {
    private final GameFileService fileGameService;
    private final SaveGameService saveGameService;
    private final LoadGameService loadGameService;

    public void deleteGame(User user, String filename) {
        fileGameService.deleteGame(user, filename);
    }

    public void saveGame(User user) {
        saveGameService.saveGame(user);
    }

    public List<String> getPreviousGames(User user) {
        return fileGameService.getSavedFiles(user);
    }

    public GameSession getPreviousGameSession(User user, String filename) {
        return loadGameService.load(user, filename);
    }

    public String getNewGameFilename(User user) {
        return fileGameService.getNewGameName(user);
    }
}
