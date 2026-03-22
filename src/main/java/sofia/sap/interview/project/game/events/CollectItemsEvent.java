package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public record CollectItemsEvent(EventType eventType, Map<ItemType, Integer> items) implements GameEvent {
    public static CollectItemsEvent collectEvent(Map<ItemType, Integer> items) {
        return new CollectItemsEvent(EventType.COLLECT_ITEMS, items);
    }
}
