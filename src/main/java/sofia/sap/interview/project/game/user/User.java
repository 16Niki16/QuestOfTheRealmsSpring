package sofia.sap.interview.project.game.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sofia.sap.interview.project.game.exceptions.SessionInProgressException;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.quests.QuestLog;

@Getter
@AllArgsConstructor
public class User {
    private final String username;
    private String currentGameSessionName;
    private GameSession session;
    private QuestLog log;

    public static User createUser(String username) {
        return new User(username, null, null, null);
    }

    public boolean isActiveSession() {
        return this.currentGameSessionName != null;
    }

    public void clearSession() {
        this.currentGameSessionName = null;
        this.session = null;
        this.log = null;
    }

    public void createSession(String currentGameSessionName, GameSession session, QuestLog log) {
        if (isActiveSession()) {
            throw new SessionInProgressException("Exit the current session to start new one!");
        }

        this.currentGameSessionName = currentGameSessionName;
        this.session = session;
        this.log = log;
    }
}
