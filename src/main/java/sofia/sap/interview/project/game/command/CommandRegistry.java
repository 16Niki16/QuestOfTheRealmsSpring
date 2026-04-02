package sofia.sap.interview.project.game.command;

import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.command.commands.AttackCommand;
import sofia.sap.interview.project.game.command.commands.CheckQuestsCommand;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.commands.EquipGearCommand;
import sofia.sap.interview.project.game.command.commands.ExitCommand;
import sofia.sap.interview.project.game.command.commands.HelpCommand;
import sofia.sap.interview.project.game.command.commands.InventoryCommand;
import sofia.sap.interview.project.game.command.commands.LoadCommand;
import sofia.sap.interview.project.game.command.commands.LookCommand;
import sofia.sap.interview.project.game.command.commands.MoveCommand;
import sofia.sap.interview.project.game.command.commands.OpenChestCommand;
import sofia.sap.interview.project.game.command.commands.PathsCommand;
import sofia.sap.interview.project.game.command.commands.ResumeCommand;
import sofia.sap.interview.project.game.command.commands.SaveCommand;
import sofia.sap.interview.project.game.command.commands.UnequipGearCommand;
import sofia.sap.interview.project.game.command.commands.UseItemCommand;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.map.Direction;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class CommandRegistry {
    private static final Map<CommandOption, Function<String, Command>> commands = new EnumMap<>(CommandOption.class);
    public CommandRegistry(HelpCommand helpCommand,
                           AttackCommand attackCommand,
                           CheckQuestsCommand questsCommand,
                           LookCommand lookCommand,
                           PathsCommand pathsCommand,
                           OpenChestCommand chestCommand,
                           InventoryCommand inventoryCommand,
                           SaveCommand saveCommand,
                           ExitCommand exitCommand,
                           LoadCommand loadCommand){

        commands.put(CommandOption.HELP, args -> helpCommand);
        commands.put(CommandOption.ATTACK, args -> attackCommand);
        commands.put(CommandOption.QUESTS, args -> questsCommand);
        commands.put(CommandOption.LOOK, args -> lookCommand);
        commands.put(CommandOption.PATHS, args -> pathsCommand);
        commands.put(CommandOption.OPEN, args -> chestCommand);
        commands.put(CommandOption.INVENTORY, args -> inventoryCommand);
        commands.put(CommandOption.SAVE, args -> saveCommand);
        commands.put(CommandOption.EXIT, args -> exitCommand);
        commands.put(CommandOption.LOAD, args -> loadCommand);

        commands.put(CommandOption.EQUIP, args -> new EquipGearCommand(itemType(args)));
        commands.put(CommandOption.UNEQUIP, args -> new UnequipGearCommand(itemType(args)));
        commands.put(CommandOption.USE_ITEM, args -> new UseItemCommand(itemType(args)));
        commands.put(CommandOption.MOVE, args -> new MoveCommand(Direction.getDirection(args)));
        commands.put(CommandOption.RESUME, ResumeCommand::new);
    }

    public Command createCommand(String input) {
        String[] commandSplit = input.split(" ", 2);
        CommandOption command = CommandOption.fromString(commandSplit[0]);
        Function<String, Command> parser = commands.get(command);

        String args = commandSplit.length > 1 ? commandSplit[1] : "";
        return parser.apply(args);
    }

    private ItemType itemType(String itemName) {
        return ItemType.getByName(itemName);
    }
}
