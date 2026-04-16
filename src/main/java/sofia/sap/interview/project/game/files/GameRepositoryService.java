package sofia.sap.interview.project.game.files;

import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.dto.loadgame.LoadedSessionInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@Service
public class GameRepositoryService {
    private final GameFileService fileGameService;
    private final SaveGameService saveGameService;
    private final LoadGameService loadGameService;

    public GameRepositoryService(GameFileService fileGameService, SaveGameService saveGameService,
                                 LoadGameService loadGameService) {
        this.fileGameService = fileGameService;
        this.saveGameService = saveGameService;
        this.loadGameService = loadGameService;
    }

    public void deleteGame(User user, String filename) {
        fileGameService.deleteGame(user, filename);
    }

    public void saveGame(User user) {
        saveGameService.saveGame(user);
    }

    public List<String> getPreviousGames(User user) {
        return fileGameService.getSavedFiles(user);
    }

    public LoadedSessionInformation getPreviousGameSession(User user, String filename) {
        return loadGameService.load(user, filename);
    }

    public String getNewGameFilename(User user) {
        return fileGameService.getNewGameName(user);
    }
}
