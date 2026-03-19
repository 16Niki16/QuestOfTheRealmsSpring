package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

public record ItemUnequipEvent(EventType eventType, ItemType type, int effect) implements GameEvent {
    public static ItemUnequipEvent unequipEvent(Item item) {
        return new ItemUnequipEvent(EventType.UNEQUIP, item.getType(), item.getEffect());
    }
}
