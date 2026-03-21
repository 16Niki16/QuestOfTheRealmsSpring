package sofia.sap.interview.project.game.information;

import sofia.sap.interview.project.game.inventory.Inventory;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.Map;
import java.util.stream.Collectors;

public record InventoryInformation(Map<ItemType, Integer> inventoryContent) implements ViewInformation{
    public static InventoryInformation of(Inventory inventory) {
        Map<ItemType, Integer> inventoryContent = inventory.getItems().entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                e -> e.getValue().size()
            ));

        return new InventoryInformation(inventoryContent);
    }
}
