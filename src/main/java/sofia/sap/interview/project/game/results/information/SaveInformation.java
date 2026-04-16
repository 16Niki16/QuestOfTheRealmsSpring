package sofia.sap.interview.project.game.results.information;

import static sofia.sap.interview.project.game.results.information.ViewType.*;

public record SaveInformation(ViewType viewType, String filename) implements ViewInformation {
    public static SaveInformation of(String filename) {
        return new SaveInformation(SAVE, filename);
    }
}
