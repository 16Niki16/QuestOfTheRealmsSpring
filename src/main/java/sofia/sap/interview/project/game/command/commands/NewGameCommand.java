package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.events.NewGameEvent;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class NewGameCommand implements Command {
    private final String characterName;
    private final AllyCharacterType characterType;

    public NewGameCommand(String characterName, AllyCharacterType characterType) {
        this.characterName = characterName;
        this.characterType = characterType;
    }

    @Override
    public List<CommandResult> execute(User user) {
        user.createNewGame(characterName, characterType);

        return List.of(NewGameEvent.of(user.getSession().getCharacter()));
    }
}
