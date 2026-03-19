package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.map.room.SpecialItem;

public record CollectSpecialItemEvent(EventType type, SpecialItem item) implements GameEvent {
    public static CollectSpecialItemEvent of(SpecialItem item) {
        return new CollectSpecialItemEvent(EventType.COLLECT_SPECIAL_ITEM, item);
    }
}
