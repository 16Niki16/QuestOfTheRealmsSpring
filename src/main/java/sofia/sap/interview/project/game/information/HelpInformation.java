package sofia.sap.interview.project.game.information;

import sofia.sap.interview.project.game.dto.events.CommandDTO;

import java.util.List;

public record HelpInformation(List<CommandDTO> commands) implements ViewInformation{
}
