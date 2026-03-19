package sofia.sap.interview.project.game.exceptions;

public class QuestNotAvailableException extends RuntimeException {
    public QuestNotAvailableException(String message) {
        super(message);
    }

    public QuestNotAvailableException(String message, Throwable thr) {
        super(message, thr);
    }
}
