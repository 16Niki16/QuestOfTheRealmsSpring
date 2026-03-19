package sofia.sap.interview.project.game.inventory;

import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private final Map<ItemType, List<Item>> items;

    public Inventory() {
        this.items = new EnumMap<>(ItemType.class);
    }

    public Inventory(Map<ItemType, List<Item>> items) {
        this.items = items;
    }

    public Map<ItemType, List<Item>> getItems() {
        return this.items;
    }

    public void addItem(Item item) {
        this.items.computeIfAbsent(item.getType(), k -> new ArrayList<>())
                .add(item);
    }

    public void addAllItems(Collection<Item> items) {
        for (Item item : items) {
            addItem(item);
        }
    }

    public Item getItem(ItemType itemType) {
        List<Item> items = this.items.get(itemType);

        if (items == null || items.isEmpty()) {
            throw new ItemNotAvailableException("The provided item is not in the inventory!");
        }

        return items.getFirst();
    }

    public void removeItem(Item item) {
        List<Item> items = this.items.get(item.getType());

        if (items == null || !items.contains(item)) {
            throw new ItemNotAvailableException("There is not an item to remove!");
        }
        items.remove(item);
    }
}
