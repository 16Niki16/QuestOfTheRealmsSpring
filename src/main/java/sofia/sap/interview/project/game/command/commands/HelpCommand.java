package sofia.sap.interview.project.game.command.commands;

import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.dto.events.CommandDTO;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.information.HelpInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@Component
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
                new CommandDTO("inventory", "Check the available items in the inventory!"),
                new CommandDTO("quests", "Shows list with active and completed quests!"),
                new CommandDTO("save [filename]", "Save the current game session!"),
                new CommandDTO("load", "Provides a list of saved games!"),
                new CommandDTO("resume [filename]", "Load one of the saved games!"),
                new CommandDTO("exit", "Exit the game!")
        );

        return List.of(HelpInformation.of(commands));
    }
}
