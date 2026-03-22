package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class LoadCommand implements Command {
    private final String filename;

    public LoadCommand(String filename) {
        this.filename = filename;
    }

    @Override
    public List<CommandResult> execute(User user) {
        return null;
    }
}
