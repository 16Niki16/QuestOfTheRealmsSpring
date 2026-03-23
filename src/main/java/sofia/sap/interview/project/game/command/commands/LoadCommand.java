package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.information.LoadInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

import static sofia.sap.interview.project.game.files.SavedGamesList.*;

public class LoadCommand implements Command {
    @Override
    public List<CommandResult> execute(User user) {
        List<String> savedGames = user.savedGames();
        return List.of(new ViewResult(new LoadInformation(savedGames)));
    }
}
