package sofia.sap.interview.project.game.exceptions;

public class UsernameAlreadyExistException extends RuntimeException {
    public UsernameAlreadyExistException(String message) {
        super(message);
    }

    public UsernameAlreadyExistException(String message, Throwable thr) {
        super(message, thr);
    }
}
