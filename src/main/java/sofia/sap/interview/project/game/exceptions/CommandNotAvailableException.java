package sofia.sap.interview.project.game.exceptions;

public class CommandNotAvailableException extends RuntimeException {
    public CommandNotAvailableException(String message) {
        super(message);
    }

    public CommandNotAvailableException(String message, Throwable thr) {
        super(message, thr);
    }
}
