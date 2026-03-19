package sofia.sap.interview.project.game.command;

public enum CommandOption {
    ATTACK("attack"),
    DEFEND("defend"),
    USE_ITEM("use"),
    LOOK("look"),
    MOVE("move"),
    EQUIP("equip"),
    UNEQUIP("unequip"),
    HELP("help"),
    QUESTS("quests"),
    PATHS("paths"),
    OPEN("open");
    private final String command;

    CommandOption(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }
}
