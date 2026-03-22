package sofia.sap.interview.project.game.map.room;

import lombok.Getter;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Getter
public class Chest {
    private final Map<ItemType, Integer> content;

    private Chest(Map<ItemType, Integer> content) {
        this.content = new EnumMap<>(content);
    }

    public static Chest createChest(Map<ItemType, Integer> content) {
        return new Chest(content);
    }

    public Map<ItemType, Integer> collectItems() {
        Map<ItemType, Integer> items = Map.copyOf(this.content);
        this.content.clear();
        return items;
    }
}
