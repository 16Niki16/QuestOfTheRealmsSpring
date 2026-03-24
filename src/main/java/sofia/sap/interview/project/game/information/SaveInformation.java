package sofia.sap.interview.project.game.information;

public record SaveInformation(ViewType viewType, String filename) implements ViewInformation {
    public static SaveInformation of(String filename) {
        return new SaveInformation(ViewType.SAVE, filename);
    }
}
