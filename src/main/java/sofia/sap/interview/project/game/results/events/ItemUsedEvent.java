package sofia.sap.interview.project.game.results.events;

import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

public record ItemUsedEvent(EventType eventType, ItemType type, int itemEffect) implements GameEvent {
    public static ItemUsedEvent of(Item item) {
        ItemType itemType = item.getType();
        return new ItemUsedEvent(EventType.USE, itemType, item.getEffect());
    }
}
