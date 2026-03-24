package sofia.sap.interview.project.game.information;

import java.util.List;

public record LoadInformation(ViewType viewType, List<String> savedGames) implements ViewInformation {
    public static LoadInformation of(List<String> savedGames) {
        return new LoadInformation(ViewType.LOAD, savedGames);
    }
}
