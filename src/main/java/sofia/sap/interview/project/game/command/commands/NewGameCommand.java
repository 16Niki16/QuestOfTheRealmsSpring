package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.events.NewGameEvent;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class NewGameCommand implements Command {
    private final String name;
    private final AllyCharacterType type;

    public NewGameCommand(String name, AllyCharacterType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public List<CommandResult> execute(User user) {
        user.createNewGame(name, type);
        return List.of(new EventResult(NewGameEvent.of(user.getSession().character())));
    }
}
