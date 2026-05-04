package sofia.sap.interview.project.game.gameplay;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.characters.ally.type.CharacterType;
import sofia.sap.interview.project.game.files.GameRepositoryService;
import sofia.sap.interview.project.game.quests.QuestLog;
import sofia.sap.interview.project.game.user.User;

import static sofia.sap.interview.project.game.quests.QuestLog.createNewQuestLog;

@Service
@AllArgsConstructor
public class GameSessionService {
    private final GameFactory gameFactory;
    private final GameRepositoryService gameRepositoryService;

    public void newGame(User user, String characterName, CharacterType characterType) {
        synchronized (user) {
            String sessionName = gameRepositoryService.getNewGameFilename(user);
            GameSession session = gameFactory.createSession(sessionName, characterName, characterType);
            QuestLog log = createNewQuestLog();

            user.createSession(session);
            saveGame(user);
        }
    }

    public void resumeGame(User user, String filename) {
        synchronized (user) {
            GameSession session = gameRepositoryService.getPreviousGameSession(user, filename);
            user.createSession(session);
        }
    }

    public void saveGame(User user) {
        synchronized (user) {
            if (user.isActiveSession()) {
                gameRepositoryService.saveGame(user);
            }
        }
    }

    public void endGame(User user) {
        synchronized (user) {
            gameRepositoryService.deleteGame(user, user.getSession().sessionName());
            user.clearSession();
        }
    }

    public void exitGame(User user) {
        synchronized (user) {
            gameRepositoryService.saveGame(user);
            user.clearSession();
        }
    }
}
