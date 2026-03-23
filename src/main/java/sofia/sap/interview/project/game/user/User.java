package sofia.sap.interview.project.game.user;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.dto.loadgame.LoadedInformation;
import sofia.sap.interview.project.game.files.SaveGame;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.quests.QuestLog;

import static sofia.sap.interview.project.game.files.LoadGame.load;
import static sofia.sap.interview.project.game.files.SaveGame.*;
import static sofia.sap.interview.project.game.gameplay.GameFactory.createSession;

@Getter
public class User {
    private final String username;
    private String currentGameSessionName;
    private GameSession session;
    private QuestLog log;

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
        this.log = new QuestLog();
        this.session = createSession(name, type);
        this.currentGameSessionName = saveGame(this);
    }

    public void endGame() {
        this.currentGameSessionName = null;
        this.session = null;
        this.log = null;
    }

    public void loadGame(String filename) {
        LoadedInformation info = load(this, filename);
        this.currentGameSessionName = filename;
        this.session = info.session();
        this.log = info.log();
    }
}
