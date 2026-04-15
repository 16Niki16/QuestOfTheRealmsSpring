package sofia.sap.interview.project.game.command.commands;

import lombok.AllArgsConstructor;
import sofia.sap.interview.project.game.characters.ally.type.CharacterType;
import sofia.sap.interview.project.game.gameplay.GameSessionService;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.events.NewGameEvent;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@AllArgsConstructor
public class NewGameCommand implements Command {
    private GameSessionService gameSessionService;
    private final String characterName;
    private final CharacterType characterType;

    @Override
    public List<CommandResult> execute(User user) {
        gameSessionService.newGame(user, characterName, characterType);

        return List.of(NewGameEvent.of(user.getSession().getCharacter()));
    }
}
