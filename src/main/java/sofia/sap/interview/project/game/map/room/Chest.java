package sofia.sap.interview.project.game.map.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.Map;

@Getter
@AllArgsConstructor
public class Chest {
    private final Map<ItemType, Integer> content;

    public Map<ItemType, Integer> collectItems() {
        Map<ItemType, Integer> items = Map.copyOf(this.content);
        this.content.clear();

        return items;
    }
}
