package sofia.sap.interview.project.game.events;

public record ExitEvent(EventType eventType, String filename) implements GameEvent {
    public static ExitEvent of(String filename) {
        return new ExitEvent(EventType.EXIT, filename);
    }
}
