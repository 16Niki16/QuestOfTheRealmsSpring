package sofia.sap.interview.project.game.exceptions;

public class ItemTypeAlreadyEquippedException extends RuntimeException {
    public ItemTypeAlreadyEquippedException(String message) {
        super(message);
    }

    public ItemTypeAlreadyEquippedException(String message, Throwable thr) {
        super(message, thr);
    }
}
