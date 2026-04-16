package sofia.sap.interview.project.game.results.information;

import static sofia.sap.interview.project.game.results.information.ViewType.*;

public record ExitInformation(ViewType viewType, String filename) implements ViewInformation {
    public static ExitInformation of(String filename) {
        return new ExitInformation(EXIT, filename);
    }
}
