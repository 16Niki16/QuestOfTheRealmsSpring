package sofia.sap.interview.project.game.command;

import lombok.Getter;
import sofia.sap.interview.project.game.exceptions.CommandNotAvailableException;

import java.util.Arrays;

@Getter
public enum CommandOption {
    ATTACK("attack"),
    USE_ITEM("use"),
    LOOK("look"),
    MOVE("move"),
    EQUIP("equip"),
    UNEQUIP("unequip"),
    HELP("help"),
    QUESTS("quests"),
    PATHS("paths"),
    OPEN("open"),
    INVENTORY("inventory"),
    SAVE("save"),
    EXIT("exit"),
    LOAD("load"),
    RESUME("resume");
    private final String command;

    CommandOption(String command) {
        this.command = command;
    }

    public static CommandOption fromString(String input) {
        return Arrays.stream(values())
            .filter(c -> c.command.equalsIgnoreCase(input))
            .findFirst()
            .orElseThrow(() -> new CommandNotAvailableException("The provided command is not correct!"));
    }
}
