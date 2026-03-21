package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

public record ItemUsedEvent(EventType eventType, ItemType itemType, int itemEffect) implements GameEvent {
    public static ItemUsedEvent of(Item item) {
        return new ItemUsedEvent(EventType.USE, item.getType(), item.getEffect());
    }
}
