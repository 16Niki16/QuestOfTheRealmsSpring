package sofia.sap.interview.project.game.results.events;

import sofia.sap.interview.project.game.items.ItemType;

import java.util.Map;

public record CollectItemsEvent(EventType eventType, Map<ItemType, Integer> items) implements GameEvent {
    public static CollectItemsEvent collectEvent(Map<ItemType, Integer> items) {
        return new CollectItemsEvent(EventType.COLLECT_ITEMS, items);
    }
}
