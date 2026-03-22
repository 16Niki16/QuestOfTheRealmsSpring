package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.information.InventoryInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class InventoryCommand implements Command {
    @Override
    public List<CommandResult> execute(User user) {
        return List.of(new ViewResult(InventoryInformation.of(user.getSession().getCharacter().getInventory())));
    }
}
