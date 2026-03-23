package sofia.sap.interview.project.game.information;

import sofia.sap.interview.project.game.events.EventType;

public record ExitInformation(EventType eventType, String filename) implements ViewInformation {
    public static ExitInformation of(String filename) {
        return new ExitInformation(EventType.EXIT, filename);
    }
}
