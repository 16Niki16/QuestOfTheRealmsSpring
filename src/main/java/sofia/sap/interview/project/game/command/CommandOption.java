package sofia.sap.interview.project.game.command;

import lombok.Getter;

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
    INVENTORY("inventory");
    private final String command;

    CommandOption(String command) {
        this.command = command;
    }

}
