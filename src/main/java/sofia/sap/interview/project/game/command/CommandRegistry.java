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
import sofia.sap.interview.project.game.exceptions.CommandArgumentException;
import sofia.sap.interview.project.game.gameplay.GameSessionService;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

import static sofia.sap.interview.project.game.command.CommandOption.ATTACK;
import static sofia.sap.interview.project.game.command.CommandOption.EQUIP;
import static sofia.sap.interview.project.game.command.CommandOption.EXIT;
import static sofia.sap.interview.project.game.command.CommandOption.HELP;
import static sofia.sap.interview.project.game.command.CommandOption.INVENTORY;
import static sofia.sap.interview.project.game.command.CommandOption.LOAD;
import static sofia.sap.interview.project.game.command.CommandOption.LOOK;
import static sofia.sap.interview.project.game.command.CommandOption.MOVE;
import static sofia.sap.interview.project.game.command.CommandOption.OPEN;
import static sofia.sap.interview.project.game.command.CommandOption.PATHS;
import static sofia.sap.interview.project.game.command.CommandOption.QUESTS;
import static sofia.sap.interview.project.game.command.CommandOption.RESUME;
import static sofia.sap.interview.project.game.command.CommandOption.SAVE;
import static sofia.sap.interview.project.game.command.CommandOption.UNEQUIP;
import static sofia.sap.interview.project.game.command.CommandOption.USE_ITEM;
import static sofia.sap.interview.project.game.command.CommandOption.fromString;
import static sofia.sap.interview.project.game.map.Direction.getDirection;

@Component
public class CommandRegistry {
    private static final Map<CommandOption, Function<String, Command>> COMMANDS = new EnumMap<>(CommandOption.class);

    public CommandRegistry(GameSessionService gameSessionService,
                           HelpCommand helpCommand,
                           AttackCommand attackCommand,
                           CheckQuestsCommand questsCommand,
                           LookCommand lookCommand,
                           PathsCommand pathsCommand,
                           OpenChestCommand chestCommand,
                           InventoryCommand inventoryCommand,
                           SaveCommand saveCommand,
                           ExitCommand exitCommand,
                           LoadCommand loadCommand) {

        COMMANDS.put(HELP, args -> helpCommand);
        COMMANDS.put(ATTACK, args -> attackCommand);
        COMMANDS.put(QUESTS, args -> questsCommand);
        COMMANDS.put(LOOK, args -> lookCommand);
        COMMANDS.put(PATHS, args -> pathsCommand);
        COMMANDS.put(OPEN, args -> chestCommand);
        COMMANDS.put(INVENTORY, args -> inventoryCommand);
        COMMANDS.put(SAVE, args -> saveCommand);
        COMMANDS.put(EXIT, args -> exitCommand);
        COMMANDS.put(LOAD, args -> loadCommand);

        COMMANDS.put(EQUIP, args -> new EquipGearCommand(itemType(args)));
        COMMANDS.put(UNEQUIP, args -> new UnequipGearCommand(itemType(args)));
        COMMANDS.put(USE_ITEM, args -> new UseItemCommand(itemType(args)));
        COMMANDS.put(MOVE, args -> new MoveCommand(getDirection(args)));
        COMMANDS.put(RESUME, args -> new ResumeCommand(gameSessionService, args));
    }

    public Command createCommand(String input) {
        String[] commandSplit = input.split(" ", 2);
        CommandOption command = fromString(commandSplit[0]);
        Function<String, Command> parser = COMMANDS.get(command);

        String args = commandSplit.length > 1 ? commandSplit[1] : "";
        return parser.apply(args);
    }

    public Command getCommand(CommandOption commandOption, String argument) {
        if (argument == null) {
            throw new CommandArgumentException("The provided command argument can not be null!");
        }
        Function<String, Command> parser = COMMANDS.get(commandOption);

        if (parser == null) {
            throw new IllegalArgumentException("Unknown command: " + commandOption);
        }

        return parser.apply(argument);
    }

    public Command getCommand(CommandOption commandOption) {
        return getCommand(commandOption, "");
    }

    private ItemType itemType(String itemName) {
        return ItemType.getByName(itemName);
    }
}
