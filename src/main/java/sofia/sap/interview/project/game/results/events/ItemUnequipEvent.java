package sofia.sap.interview.project.game.results.events;

import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

public record ItemUnequipEvent(EventType eventType, ItemType type, int effect) implements GameEvent {
    public static ItemUnequipEvent unequipEvent(Item item) {
        ItemType itemType = item.getType();

        return new ItemUnequipEvent(EventType.UNEQUIP, itemType, item.getEffect());
    }
}
