package sofia.sap.interview.project.game.command;

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

public class CommandRegistry {
    private static final Map<CommandOption, Function<String, Command>> COMMANDS = new EnumMap<>(CommandOption.class);
    private static final Command HELP_COMMAND = new HelpCommand();
    private static final Command ATTACK_COMMAND = new AttackCommand();
    private static final Command QUESTS_COMMAND = new CheckQuestsCommand();
    private static final Command LOOK_COMMAND = new LookCommand();
    private static final Command PATHS_COMMAND = new PathsCommand();
    private static final Command CHEST_COMMAND = new OpenChestCommand();
    private static final Command INVENTORY_COMMAND = new InventoryCommand();
    private static final Command SAVE_COMMAND = new SaveCommand();
    private static final Command EXIT_COMMAND = new ExitCommand();
    private static final Command LOAD_COMMAND = new LoadCommand();

    static {
        COMMANDS.put(CommandOption.HELP, args -> HELP_COMMAND);
        COMMANDS.put(CommandOption.ATTACK, args -> ATTACK_COMMAND);
        COMMANDS.put(CommandOption.QUESTS, args -> QUESTS_COMMAND);
        COMMANDS.put(CommandOption.LOOK, args -> LOOK_COMMAND);
        COMMANDS.put(CommandOption.PATHS, args -> PATHS_COMMAND);
        COMMANDS.put(CommandOption.OPEN, args -> CHEST_COMMAND);
        COMMANDS.put(CommandOption.INVENTORY, args -> INVENTORY_COMMAND);
        COMMANDS.put(CommandOption.SAVE, args -> SAVE_COMMAND);
        COMMANDS.put(CommandOption.EXIT, args -> EXIT_COMMAND);
        COMMANDS.put(CommandOption.LOAD, args -> LOAD_COMMAND);

        COMMANDS.put(CommandOption.EQUIP, args -> new EquipGearCommand(itemType(args)));
        COMMANDS.put(CommandOption.UNEQUIP, args -> new UnequipGearCommand(itemType(args)));
        COMMANDS.put(CommandOption.USE_ITEM, args -> new UseItemCommand(itemType(args)));
        COMMANDS.put(CommandOption.MOVE, args -> new MoveCommand(Direction.getDirection(args)));
        COMMANDS.put(CommandOption.RESUME, ResumeCommand::new);
    }

    public static Command createCommand(String input) {
        String[] commandSplit = input.split(" ", 2);
        CommandOption command = CommandOption.fromString(commandSplit[0]);
        Function<String, Command> parser = COMMANDS.get(command);

        String args = commandSplit.length > 1 ? commandSplit[1] : "";
        return parser.apply(args);
    }

    private static ItemType itemType(String itemName) {
        return ItemType.getByName(itemName);
    }
}
