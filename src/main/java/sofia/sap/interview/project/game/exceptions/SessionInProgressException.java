package sofia.sap.interview.project.game.exceptions;

public class SessionInProgressException extends RuntimeException {
    public SessionInProgressException(String message) {
        super(message);
    }

    public SessionInProgressException(String message, Throwable thr) {
        super(message, thr);
    }
}
