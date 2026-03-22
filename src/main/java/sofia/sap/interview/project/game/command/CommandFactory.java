package sofia.sap.interview.project.game.command;

import sofia.sap.interview.project.game.command.commands.AttackCommand;
import sofia.sap.interview.project.game.command.commands.CheckQuestsCommand;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.commands.EquipGearCommand;
import sofia.sap.interview.project.game.command.commands.HelpCommand;
import sofia.sap.interview.project.game.command.commands.InventoryCommand;
import sofia.sap.interview.project.game.command.commands.LookCommand;
import sofia.sap.interview.project.game.command.commands.MoveCommand;
import sofia.sap.interview.project.game.command.commands.OpenChestCommand;
import sofia.sap.interview.project.game.command.commands.PathsCommand;
import sofia.sap.interview.project.game.command.commands.SaveCommand;
import sofia.sap.interview.project.game.command.commands.UnequipGearCommand;
import sofia.sap.interview.project.game.command.commands.UseItemCommand;
import sofia.sap.interview.project.game.exceptions.CommandNotAvailableException;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.map.Direction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static final Map<String, CommandParser> COMMANDS = new HashMap<>();
    private static final Command HELP_COMMAND = new HelpCommand();
    private static final Command ATTACK_COMMAND = new AttackCommand();
    private static final Command QUESTS_COMMAND = new CheckQuestsCommand();
    private static final Command LOOK_COMMAND = new LookCommand();
    private static final Command PATHS_COMMAND = new PathsCommand();
    private static final Command CHEST_COMMAND = new OpenChestCommand();
    private static final Command INVENTORY_COMMAND = new InventoryCommand();
    private static final Command SAVE_COMMAND = new SaveCommand();

    static {
        COMMANDS.put(CommandOption.HELP.getCommand(), args -> HELP_COMMAND);
        COMMANDS.put(CommandOption.ATTACK.getCommand(), args -> ATTACK_COMMAND);
        COMMANDS.put(CommandOption.QUESTS.getCommand(), args -> QUESTS_COMMAND);
        COMMANDS.put(CommandOption.LOOK.getCommand(), args -> LOOK_COMMAND);
        COMMANDS.put(CommandOption.PATHS.getCommand(), args -> PATHS_COMMAND);
        COMMANDS.put(CommandOption.OPEN.getCommand(), args -> CHEST_COMMAND);
        COMMANDS.put(CommandOption.INVENTORY.getCommand(), args -> INVENTORY_COMMAND);
        COMMANDS.put(CommandOption.SAVE.getCommand(), args -> SAVE_COMMAND);

        COMMANDS.put(CommandOption.EQUIP.getCommand(), args -> new EquipGearCommand(itemType(args[0])));
        COMMANDS.put(CommandOption.UNEQUIP.getCommand(), args -> new UnequipGearCommand(itemType(args[0])));
        COMMANDS.put(CommandOption.USE_ITEM.getCommand(), args -> new UseItemCommand(itemType(args[0])));
        COMMANDS.put(CommandOption.MOVE.getCommand(), args -> new MoveCommand(Direction.getDirection(args[0])));
    }

    public static Command createCommand(String input) {
        String[] commandSplit = input.split(" ", 2);
        String clientCommand = commandSplit[0].toLowerCase();
        CommandParser parser = COMMANDS.get(clientCommand);

        if (parser == null) {
            throw new CommandNotAvailableException("The provided command is not correct!");
        }

        String[] args = Arrays.copyOfRange(commandSplit, 1, commandSplit.length);
        return parser.parse(args);
    }

    private static ItemType itemType(String itemName) {
        return ItemType.getByName(itemName);
    }
}
