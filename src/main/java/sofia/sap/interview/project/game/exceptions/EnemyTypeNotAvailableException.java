package sofia.sap.interview.project.game.exceptions;

public class EnemyTypeNotAvailableException extends RuntimeException {
    public EnemyTypeNotAvailableException(String message) {
        super(message);
    }

    public EnemyTypeNotAvailableException(String message, Throwable thr) {
    }
}
