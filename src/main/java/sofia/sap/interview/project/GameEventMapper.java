package sofia.sap.interview.project;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.exceptions.UnknownResultTypeException;

import java.util.List;

public class GameEventMapper {
    public static List<Object> result(List<CommandResult> results) {
        return results.stream()
            .map(result -> switch (result) {
                case EventResult e -> e.event();
                case ViewResult v -> v.information();
                default -> throw new UnknownResultTypeException("Unknown result type");
            })
            .toList();
    }
}
