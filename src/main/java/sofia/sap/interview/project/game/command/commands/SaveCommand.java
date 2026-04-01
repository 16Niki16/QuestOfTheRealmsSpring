package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.information.SaveInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class SaveCommand implements Command {
    @Override
    public List<CommandResult> execute(User user) {
        user.save();

        return List.of(SaveInformation.of(user.getCurrentGameSessionName()));
    }
}
