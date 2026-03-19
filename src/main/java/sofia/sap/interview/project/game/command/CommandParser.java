package sofia.sap.interview.project.game.command;

import sofia.sap.interview.project.game.command.commands.Command;

public interface CommandParser {
    Command parse(String[] args);
}
