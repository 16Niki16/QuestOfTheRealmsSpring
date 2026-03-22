package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.files.SavedGamesList;
import sofia.sap.interview.project.game.information.LoadInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class LoadListCommand implements Command {
    @Override
    public List<CommandResult> execute(User user) {
        List<String> savedGames = SavedGamesList.getSaveFiles(user);
        return List.of(new ViewResult(new LoadInformation(savedGames)));
    }
}
