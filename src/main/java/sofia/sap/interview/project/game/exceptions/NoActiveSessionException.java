package sofia.sap.interview.project.game.exceptions;

public class NoActiveSessionException extends RuntimeException {
    public NoActiveSessionException(String message) {
        super(message);
    }

    public NoActiveSessionException(String message, Throwable thr) {
        super(message, thr);
    }
}
