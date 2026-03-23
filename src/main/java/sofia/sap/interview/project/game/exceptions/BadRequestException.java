package sofia.sap.interview.project.game.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable thr) {
        super(message, thr);
    }
}
