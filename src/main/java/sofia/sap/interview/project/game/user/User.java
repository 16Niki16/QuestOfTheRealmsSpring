package sofia.sap.interview.project.game.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sofia.sap.interview.project.game.exceptions.SessionInProgressException;
import sofia.sap.interview.project.game.gameplay.GameSession;

@Getter
@AllArgsConstructor
public class User {
    private final String username;
    private GameSession session;

    public static User createUser(String username) {
        return new User(username, null);
    }

    public boolean isActiveSession() {
        return this.session != null;
    }

    public void clearSession() {
        this.session = null;
    }

    public void createSession(GameSession session) {
        if (isActiveSession()) {
            throw new SessionInProgressException("Exit the current session to start new one!");
        }

        this.session = session;
    }
}
