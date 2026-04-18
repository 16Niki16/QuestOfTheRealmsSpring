package sofia.sap.interview.project.game.results.events;

import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

import static sofia.sap.interview.project.game.results.events.EventType.*;

public record ItemUsedEvent(EventType eventType, ItemType type, int itemEffect) implements GameEvent {
    public static ItemUsedEvent of(Item item) {
        return new ItemUsedEvent(USE, item.getType(), item.getEffect());
    }
}
