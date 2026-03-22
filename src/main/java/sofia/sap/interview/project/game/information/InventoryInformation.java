package sofia.sap.interview.project.game.information;

import sofia.sap.interview.project.game.inventory.Inventory;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.Map;
import java.util.stream.Collectors;

public record InventoryInformation(Map<ItemType, Integer> inventoryContent) implements ViewInformation{
    public static InventoryInformation of(Inventory inventory) {
        return new InventoryInformation(inventory.getItems());
    }
}
