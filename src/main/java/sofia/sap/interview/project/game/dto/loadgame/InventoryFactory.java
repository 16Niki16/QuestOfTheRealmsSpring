package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.dto.savegame.data.InventoryData;
import sofia.sap.interview.project.game.inventory.Inventory;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemFactory;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InventoryFactory {
    public static Inventory create(InventoryData data) {
        Map<ItemType, List<Item>> items = data.items().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> IntStream.range(0, entry.getValue())
                                .mapToObj(i -> ItemFactory.create(entry.getKey()))
                                .collect(Collectors.toCollection(ArrayList::new))));
        return new Inventory(items);
    }
}
