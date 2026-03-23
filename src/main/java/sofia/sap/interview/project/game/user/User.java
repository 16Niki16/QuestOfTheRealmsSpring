package sofia.sap.interview.project.game.user;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.dto.loadgame.LoadedInformation;
import sofia.sap.interview.project.game.files.EndGame;
import sofia.sap.interview.project.game.files.SaveGame;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.quests.QuestLog;

import static sofia.sap.interview.project.game.files.LoadGame.load;
import static sofia.sap.interview.project.game.files.NewGameSave.*;
import static sofia.sap.interview.project.game.gameplay.GameFactory.createSession;
import static sofia.sap.interview.project.game.quests.QuestLog.*;

@Getter
public class User {
    private final String username;
    private String currentGameSessionName;
    private GameSession session;
    private QuestLog log;
    private final Object saveLock = new Object();

    private User(String username, String currentGameSessionName, GameSession session, QuestLog log) {
        this.username = username;
        this.currentGameSessionName = currentGameSessionName;
        this.session = session;
        this.log = log;
    }

    public static User createUser(String username) {
        return new User(username, null, null, null);
    }

    public boolean isActiveSession() {
        return this.session != null && this.log != null;
    }

    public void createNewGame(String name, AllyCharacterType type) {
        synchronized (saveLock) {
            this.log = createNewQuestLog();
            this.session = createSession(name, type);
            this.currentGameSessionName = saveNewGame(this);
        }
    }

    public void endGame() {
        synchronized (saveLock) {
            EndGame.endGame(this, currentGameSessionName);
            this.currentGameSessionName = null;
            this.session = null;
            this.log = null;
        }
    }

    public void resumeGame(String filename) {
        synchronized (saveLock) {
            LoadedInformation info = load(this, filename);
            this.currentGameSessionName = filename;
            this.session = info.session();
            this.log = info.log();
        }
    }

    public void save() {
        synchronized (saveLock) {
            SaveGame.saveGame(this);
        }
    }
}
