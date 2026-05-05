package sofia.sap.interview.project.game.results.information;

import java.util.List;

import static sofia.sap.interview.project.game.results.information.ViewType.LOAD;

public record LoadInformation(ViewType viewType, List<String> savedGames) implements ViewInformation {
    public static LoadInformation of(List<String> savedGames) {
        return new LoadInformation(LOAD, savedGames);
    }
}
