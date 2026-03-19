package sofia.sap.interview.project.game.exceptions;

public class UserNotKnownException extends RuntimeException {
    public UserNotKnownException(String message) {
        super(message);
    }

    public UserNotKnownException(String message, Throwable thr) {
        super(message, thr);
    }
}
