package sofia.sap.interview.project.game.command.result;

import sofia.sap.interview.project.game.events.GameEvent;

public record EventResult(GameEvent event) implements CommandResult {
}
