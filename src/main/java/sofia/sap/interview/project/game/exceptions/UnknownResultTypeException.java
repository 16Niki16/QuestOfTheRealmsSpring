package sofia.sap.interview.project.game.exceptions;

public class UnknownResultTypeException extends RuntimeException {
    public UnknownResultTypeException(String message) {
        super(message);
    }

    public UnknownResultTypeException(String message, Throwable thr) {
        super(message, thr);
    }
}
