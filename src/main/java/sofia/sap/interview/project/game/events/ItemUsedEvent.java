package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

public record ItemUsedEvent(EventType eventType, ItemType type, int itemEffect, String source) implements GameEvent {
    public static ItemUsedEvent of(Item item) {
        ItemType itemType = item.getType();
        return new ItemUsedEvent(EventType.USE, itemType, item.getEffect(), itemType.getSource());
    }
}
