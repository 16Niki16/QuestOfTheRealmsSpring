package sofia.sap.interview.project.game.results.information;

import sofia.sap.interview.project.game.dto.events.CommandDTO;

import java.util.List;

public record HelpInformation(ViewType viewType, List<CommandDTO> commands) implements ViewInformation {
    public static HelpInformation of(List<CommandDTO> commands) {
        return new HelpInformation(ViewType.HELP, commands);
    }
}
