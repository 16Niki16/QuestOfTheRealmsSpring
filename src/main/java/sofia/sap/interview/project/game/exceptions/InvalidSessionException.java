package sofia.sap.interview.project.game.exceptions;

public class InvalidSessionException extends RuntimeException {
    public InvalidSessionException(String message) {
        super(message);
    }

    public InvalidSessionException(String message, Throwable thr) {
        super(message, thr);
    }
}
