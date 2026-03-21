package sofia.sap.interview.project.game.exceptions;

public class EndGameFileException extends RuntimeException {
    public EndGameFileException(String message) {
        super(message);
    }

    public EndGameFileException(String message, Throwable thr) {
        super(message, thr);
    }
}
