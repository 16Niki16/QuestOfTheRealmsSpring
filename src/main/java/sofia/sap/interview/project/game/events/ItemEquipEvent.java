package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

public record ItemEquipEvent(EventType eventType, ItemType type, int effect) implements GameEvent {
    public static ItemEquipEvent equipEvent(Item item) {
        return new ItemEquipEvent(EventType.EQUIP, item.getType(), item.getEffect());
    }
}
