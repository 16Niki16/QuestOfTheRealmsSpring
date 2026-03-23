package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

public record ItemEquipEvent(EventType eventType, ItemType type, int effect, String source) implements GameEvent {
    public static ItemEquipEvent equipEvent(Item item) {
        ItemType itemType = item.getType();
        return new ItemEquipEvent(EventType.EQUIP, itemType, item.getEffect(), itemType.getSource());
    }
}
