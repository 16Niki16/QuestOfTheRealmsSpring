package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.dto.savegame.data.EquipmentData;
import sofia.sap.interview.project.game.inventory.Equipment;

public class EquipmentDataFactory {
    public static EquipmentData create(Equipment equipment) {
        return new EquipmentData(equipment.getItems());
    }
}
