package sofia.sap.interview.project.game.inventory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.EnumMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public class Inventory {
    private final Map<ItemType, Integer> items;

    public static Inventory newCharacterInventory() {
        return new Inventory(new EnumMap<>(ItemType.class));
    }

    public void addItem(Item item) {
        this.items.merge(item.getType(), 1, Integer::sum);
    }

    public void addAllItems(Map<ItemType, Integer> items) {
        items.forEach((type, count) ->
            this.items.merge(type, count, Integer::sum));
    }

    public void removeItem(Item item) {
        items.computeIfPresent(item.getType(), (type, count) -> (count > 1) ? count - 1 : null);
    }

    public boolean checkItemAvailable(Item item) {
        Integer numberOfItemByType = this.items.get(item.getType());

        return numberOfItemByType != null && numberOfItemByType > 0;
    }
}
