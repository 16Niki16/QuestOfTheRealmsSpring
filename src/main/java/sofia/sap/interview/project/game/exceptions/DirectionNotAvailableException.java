package sofia.sap.interview.project.game.exceptions;

public class DirectionNotAvailableException extends RuntimeException {
    public DirectionNotAvailableException(String message) {
        super(message);
    }

    public DirectionNotAvailableException(String message, Throwable thr) {
        super(message, thr);
    }
}
