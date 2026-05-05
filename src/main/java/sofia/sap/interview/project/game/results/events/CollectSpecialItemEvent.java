package sofia.sap.interview.project.game.results.events;

import sofia.sap.interview.project.game.map.room.SpecialItem;

import static sofia.sap.interview.project.game.results.events.EventType.COLLECT_SPECIAL_ITEM;

public record CollectSpecialItemEvent(EventType eventType, SpecialItem item) implements GameEvent {
    public static CollectSpecialItemEvent of(SpecialItem item) {
        return new CollectSpecialItemEvent(COLLECT_SPECIAL_ITEM, item);
    }
}
