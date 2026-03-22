package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.files.AutoSaveGame;
import sofia.sap.interview.project.game.files.SaveGame;
import sofia.sap.interview.project.game.information.SaveInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

import static sofia.sap.interview.project.game.files.AutoSaveGame.*;
import static sofia.sap.interview.project.game.files.SaveGame.*;

public class SaveCommand implements Command {
    @Override
    public List<CommandResult> execute(User user) {
        autoSaveGame(user);
        return List.of(new ViewResult(new SaveInformation(user.getCurrentGameSessionName())));
    }
}
