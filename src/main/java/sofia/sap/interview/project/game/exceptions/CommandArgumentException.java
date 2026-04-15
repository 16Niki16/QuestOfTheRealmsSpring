package sofia.sap.interview.project.game.exceptions;

public class CommandArgumentException extends RuntimeException {
    public CommandArgumentException(String message) {
        super(message);
    }

    public CommandArgumentException(String message, Throwable thr) {
        super(message, thr);
    }
}
