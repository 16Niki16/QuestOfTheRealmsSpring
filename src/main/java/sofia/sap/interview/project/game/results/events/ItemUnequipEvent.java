package sofia.sap.interview.project.game.results.events;

import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;

import static sofia.sap.interview.project.game.results.events.EventType.UNEQUIP;

public record ItemUnequipEvent(EventType eventType, ItemType type, int effect) implements GameEvent {
    public static ItemUnequipEvent unequipEvent(Item item) {
        return new ItemUnequipEvent(UNEQUIP, item.getType(), item.getEffect());
    }
}
