package sofia.sap.interview.project.game.dto.savegame;

import sofia.sap.interview.project.game.dto.data.EquipmentData;
import sofia.sap.interview.project.game.inventory.Equipment;

public class EquipmentDataFactory {
    public static EquipmentData create(Equipment equipment) {
        return new EquipmentData(equipment.getItems());
    }
}
