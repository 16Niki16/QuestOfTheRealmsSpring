package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.dto.events.CommandDTO;
import sofia.sap.interview.project.game.information.HelpInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class HelpCommand implements Command {

    @Override
    public List<CommandResult> execute(User user) {
        List<CommandDTO> commands = List.of(
                new CommandDTO("move [north | south | east | west]", "Choose direction to continue!"),
                new CommandDTO("look", "Look to see what the current destination contains!"),
                new CommandDTO("attack", "Attack the enemy at the current location!"),
                new CommandDTO("open", "Collect the items from the chest!"),
                new CommandDTO("use [item]", "Use some of the collected items in the inventory!"),
                new CommandDTO("equip [item]", "Equip item from the inventory to increase your stats!"),
                new CommandDTO("unequip [item]", "Unequip item!"),
                new CommandDTO("quests", "Shows list with active and completed quests!"),
                new CommandDTO("save", "Save the current game session!"),
                new CommandDTO("exit", "Exit the game!")
        );

        return List.of(new ViewResult(new HelpInformation(commands)));
    }
}
