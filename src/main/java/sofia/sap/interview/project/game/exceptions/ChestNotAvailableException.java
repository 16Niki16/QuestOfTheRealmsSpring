package sofia.sap.interview.project.game.exceptions;

public class ChestNotAvailableException extends RuntimeException {
    public ChestNotAvailableException(String message) {
        super(message);
    }

    public ChestNotAvailableException(String message, Throwable thr) {
        super(message, thr);
    }
}
