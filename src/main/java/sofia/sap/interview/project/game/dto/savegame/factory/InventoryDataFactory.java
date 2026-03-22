package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.dto.savegame.data.InventoryData;
import sofia.sap.interview.project.game.inventory.Inventory;

public class InventoryDataFactory {
    public static InventoryData create(Inventory inventory) {
        return new InventoryData(inventory.getItems());
    }
}
