package sofia.sap.interview.project.game.exceptions;

public class NewGameMapException extends RuntimeException {
    public NewGameMapException(String message) {
        super(message);
    }

    public NewGameMapException(String message, Throwable thr) {
        super(message, thr);
    }
}
