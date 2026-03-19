package sofia.sap.interview.project.game.exceptions;

public class NewGameFileException extends RuntimeException {
    public NewGameFileException(String message) {
        super(message);
    }

    public NewGameFileException(String message, Throwable thr) {
        super(message, thr);
    }
}
