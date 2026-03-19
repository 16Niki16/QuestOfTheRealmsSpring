package sofia.sap.interview.project.game.command.result;

import sofia.sap.interview.project.game.information.ViewInformation;

public record ViewResult(ViewInformation information) implements CommandResult {
}
