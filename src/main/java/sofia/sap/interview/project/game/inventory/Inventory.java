package sofia.sap.interview.project.game.inventory;

import lombok.Getter;
import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemFactory;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Getter
public class Inventory {
    private final Map<ItemType, Integer> items;

    public Inventory() {
        this.items = new EnumMap<>(ItemType.class);
    }

    public Inventory(Map<ItemType, Integer> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        this.items.merge(item.getType(), 1, Integer::sum);
    }

    public void addAllItems(Collection<Item> items) {
        for (Item item : items) {
            addItem(item);
        }
    }

    public Item getItem(ItemType itemType) {
        Integer count = this.items.get(itemType);
        if (count == null || count == 0) {
            throw new ItemNotAvailableException("The provided item is not in the inventory!");
        }
        return ItemFactory.create(itemType);
    }

    public void removeItem(Item item) {
        Integer count = this.items.get(item.getType());
        if (count == null || count == 0) {
            throw new ItemNotAvailableException("There is not an item to remove!");
        }
        this.items.put(item.getType(), count - 1);
    }
}
