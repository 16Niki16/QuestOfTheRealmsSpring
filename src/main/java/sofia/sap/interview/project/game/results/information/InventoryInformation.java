package sofia.sap.interview.project.game.results.information;

import sofia.sap.interview.project.game.inventory.Inventory;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.Map;

import static sofia.sap.interview.project.game.results.information.ViewType.*;

public record InventoryInformation(ViewType viewType, Map<ItemType, Integer> inventoryContent)
        implements ViewInformation {
    public static InventoryInformation of(Inventory inventory) {
        return new InventoryInformation(INVENTORY, inventory.getItems());
    }
}
