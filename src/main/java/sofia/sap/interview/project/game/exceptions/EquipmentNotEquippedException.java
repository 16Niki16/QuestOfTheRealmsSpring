package sofia.sap.interview.project.game.exceptions;

public class EquipmentNotEquippedException extends RuntimeException {
    public EquipmentNotEquippedException(String message) {
        super(message);
    }

    public EquipmentNotEquippedException(String message, Throwable thr) {
        super(message, thr);
    }
}
