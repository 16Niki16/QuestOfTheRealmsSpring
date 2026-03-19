package sofia.sap.interview.project.game.exceptions;

public class LoadGameException extends RuntimeException {
    public LoadGameException(String message) {
        super(message);
    }

    public LoadGameException(String message, Throwable thr) {
        super(message, thr);
    }
}
