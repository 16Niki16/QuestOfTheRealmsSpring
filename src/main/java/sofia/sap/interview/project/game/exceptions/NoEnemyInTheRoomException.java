package sofia.sap.interview.project.game.exceptions;

public class NoEnemyInTheRoomException extends RuntimeException {
    public NoEnemyInTheRoomException(String message) {
        super(message);
    }

    public NoEnemyInTheRoomException(String message, Throwable thr) {
        super(message, thr);
    }
}
