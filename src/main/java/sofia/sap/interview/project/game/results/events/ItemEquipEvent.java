package sofia.sap.interview.project.game.results.events;

import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

import static sofia.sap.interview.project.game.results.events.EventType.*;

public record ItemEquipEvent(EventType eventType, ItemType type, int effect) implements GameEvent {
    public static ItemEquipEvent equipEvent(Item item) {
        ItemType itemType = item.getType();
        return new ItemEquipEvent(EQUIP, itemType, item.getEffect());
    }
}
