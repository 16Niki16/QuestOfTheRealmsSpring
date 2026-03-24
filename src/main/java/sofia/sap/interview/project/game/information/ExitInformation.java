package sofia.sap.interview.project.game.information;

public record ExitInformation(ViewType viewType, String filename) implements ViewInformation {
    public static ExitInformation of(String filename) {
        return new ExitInformation(ViewType.EXIT, filename);
    }
}
