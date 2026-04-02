package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.dto.data.InventoryData;
import sofia.sap.interview.project.game.inventory.Inventory;

public class InventoryFactory {
    public static Inventory create(InventoryData data) {
        return new Inventory(data.items());
    }
}
