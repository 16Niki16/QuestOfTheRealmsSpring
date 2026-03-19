package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.information.PathsInformation;
import sofia.sap.interview.project.game.map.Direction;
import sofia.sap.interview.project.game.user.User;

import java.util.List;
import java.util.Set;

public class PathsCommand implements Command {
    @Override
    public List<CommandResult> execute(User user) {
        Set<Direction> possibleDirections = user.getSession().gameplay().getPossibleDirections();

        return List.of(new ViewResult(new PathsInformation(possibleDirections)));
    }
}
