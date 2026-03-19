package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.dto.savegame.data.InventoryData;
import sofia.sap.interview.project.game.inventory.Inventory;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.Map;
import java.util.stream.Collectors;

public class InventoryDataFactory {
    public static InventoryData create(Inventory inventory) {
        Map<ItemType, Integer> items = inventory.getItems()
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().size()
                ));
        return new InventoryData(items);
    }
}
