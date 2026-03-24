package sofia.sap.interview.project.game.map.room;

import lombok.Getter;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.EnumMap;
import java.util.Map;

@Getter
public record Chest(Map<ItemType, Integer> content) {
    public Chest(Map<ItemType, Integer> content) {
        this.content = new EnumMap<>(content);
    }

    public Map<ItemType, Integer> collectItems() {
        Map<ItemType, Integer> items = Map.copyOf(this.content);
        this.content.clear();

        return items;
    }
}
