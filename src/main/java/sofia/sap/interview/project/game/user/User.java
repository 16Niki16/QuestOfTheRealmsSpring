package sofia.sap.interview.project.game.user;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.dto.loadgame.LoadedInformation;
import sofia.sap.interview.project.game.files.LoadGame;
import sofia.sap.interview.project.game.gameplay.GameFactory;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.quests.QuestLog;

@Getter
public class User {
    private final String username;
    private boolean activeSession;
    private GameSession session;
    private QuestLog log;

    private User(String username, GameSession session, QuestLog log, boolean activeSession) {
        this.username = username;
        this.session = session;
        this.log = log;
        this.activeSession = activeSession;
    }

    public static User createUser(String username) {
        return new User(username, null, null, false);
    }

    public void createNewGame(String name, AllyCharacterType type) {
        this.log = new QuestLog();
        this.session = GameFactory.createSession(name, type);
        this.activeSession = true;
    }

    public void endGame() {
        this.activeSession = false;
        this.session = null;
        this.log = null;
    }

    public void loadGame() {
        LoadedInformation info = LoadGame.loadGame(this.username);
        this.session = info.session();
        this.log = info.log();
        this.activeSession = true;
    }
}
