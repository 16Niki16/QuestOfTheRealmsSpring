package sofia.sap.interview.project.game.exceptions;

public class ItemNotAvailableException extends RuntimeException {
    public ItemNotAvailableException(String message) {
        super(message);
    }

    public ItemNotAvailableException(String message, Throwable thr) {
        super(message, thr);
    }
}
