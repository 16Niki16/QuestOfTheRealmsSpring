package sofia.sap.interview.project.game.exceptions;

public class QuestTypeNotFoundException extends RuntimeException {
    public QuestTypeNotFoundException(String message) {
        super(message);
    }

    public QuestTypeNotFoundException(String message, Throwable thr) {
        super(message, thr);
    }
}
