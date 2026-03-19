package sofia.sap.interview.project.game.exceptions;

public class SaveGameException extends RuntimeException {
    public SaveGameException(String message) {
        super(message);
    }

    public SaveGameException(String message, Throwable thr) {
        super(message, thr);
    }
}
