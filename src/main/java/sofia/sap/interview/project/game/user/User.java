package sofia.sap.interview.project.game.user;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.dto.loadgame.LoadedInformation;
import sofia.sap.interview.project.game.files.LoadGame;
import sofia.sap.interview.project.game.gameplay.GameFactory;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.quests.QuestLog;

import static sofia.sap.interview.project.game.files.LoadGame.load;
import static sofia.sap.interview.project.game.gameplay.GameFactory.createSession;

@Getter
public class User {
    private final String username;
    private GameSession session;
    private QuestLog log;

    private User(String username, GameSession session, QuestLog log) {
        this.username = username;
        this.session = session;
        this.log = log;
    }

    public static User createUser(String username) {
        return new User(username, null, null);
    }

    public boolean isActiveSession() {
        return this.session != null && this.log != null;
    }

    public void createNewGame(String name, AllyCharacterType type) {
        this.log = new QuestLog();
        this.session = createSession(name, type);
    }

    public void endGame() {
        this.session = null;
        this.log = null;
    }

    public void loadGame() {
        LoadedInformation info = load(this.username);
        this.session = info.session();
        this.log = info.log();
    }
}
