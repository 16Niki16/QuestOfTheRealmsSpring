package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.dto.savegame.data.EquipmentData;
import sofia.sap.interview.project.game.inventory.Equipment;

public class EquipmentFactory {
    public static Equipment create(EquipmentData data) {
        return new Equipment(data.equipped());
    }
}
