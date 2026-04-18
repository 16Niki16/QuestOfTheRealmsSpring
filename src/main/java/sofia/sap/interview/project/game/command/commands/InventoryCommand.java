package sofia.sap.interview.project.game.command.commands;

import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.inventory.Inventory;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.information.InventoryInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@Component
public class InventoryCommand implements Command {
    @Override
    public List<CommandResult> execute(User user) {
        Inventory inventory = user.getSession().character().getInventory();

        return List.of(InventoryInformation.of(inventory));
    }
}
