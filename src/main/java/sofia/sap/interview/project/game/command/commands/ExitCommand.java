package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.information.ExitInformation;
import sofia.sap.interview.project.game.files.SaveGame;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class ExitCommand implements Command {
    @Override
    public List<CommandResult> execute(User user) {
        user.save();
        String filename = user.getCurrentGameSessionName();
        user.endGame();
        return List.of(new ViewResult(ExitInformation.of(filename)));
    }
}
