package sofia.sap.interview.project.game.dto.savegame;

import sofia.sap.interview.project.game.dto.data.InventoryData;
import sofia.sap.interview.project.game.inventory.Inventory;

public class InventoryDataFactory {
    public static InventoryData create(Inventory inventory) {
        return new InventoryData(inventory.getItems());
    }
}
