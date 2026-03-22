package sofia.sap.interview.project.game.information;

import java.util.List;

public record LoadInformation(List<String> savedGames) implements ViewInformation {
}
