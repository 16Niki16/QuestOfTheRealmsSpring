package sofia.sap.interview.project.game.results.events;

import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

public record ItemEquipEvent(EventType eventType, ItemType type, int effect) implements GameEvent {
    public static ItemEquipEvent equipEvent(Item item) {
        ItemType itemType = item.getType();
        return new ItemEquipEvent(EventType.EQUIP, itemType, item.getEffect());
    }
}
