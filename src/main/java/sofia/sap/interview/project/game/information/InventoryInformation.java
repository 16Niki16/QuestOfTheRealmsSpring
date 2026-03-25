package sofia.sap.interview.project.game.information;

import sofia.sap.interview.project.game.inventory.Inventory;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.Map;

public record InventoryInformation(ViewType viewType, Map<ItemType, Integer> inventoryContent)
        implements ViewInformation {
    public static InventoryInformation of(Inventory inventory) {
        return new InventoryInformation(ViewType.INVENTORY, inventory.getItems());
    }
}
