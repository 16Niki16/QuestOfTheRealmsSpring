package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public interface Command {
    List<CommandResult> execute(User user);
}
