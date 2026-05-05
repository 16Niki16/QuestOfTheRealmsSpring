package sofia.sap.interview.project.game;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.command.CommandRegistry;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.commands.NewGameCommand;
import sofia.sap.interview.project.game.command.commands.ResumeCommand;
import sofia.sap.interview.project.game.exceptions.UserNotFoundException;
import sofia.sap.interview.project.game.exceptions.UsernameAlreadyExistException;
import sofia.sap.interview.project.game.gameplay.GameSessionService;
import sofia.sap.interview.project.game.request.CommandRequest;
import sofia.sap.interview.project.game.request.NewGameRequest;
import sofia.sap.interview.project.game.request.ResumeGameRequest;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.EventsProcessor;
import sofia.sap.interview.project.game.user.User;
import sofia.sap.interview.project.game.user.UserRegistry;

import java.util.List;

import static sofia.sap.interview.project.game.command.CommandOption.LOAD;
import static sofia.sap.interview.project.game.user.User.createUser;

@Service
@AllArgsConstructor
public class GameService {
    private final CommandRegistry commandRegistry;
    private final GameSessionService gameSessionService;
    private final EventsProcessor eventsProcessor;
    private final UserRegistry userRegistry;

    public void registerUser(String username) {
        User user = userRegistry.connectUser(username, createUser(username));

        if (user != null) {
            throw new UsernameAlreadyExistException("Username already taken: " + username);
        }
    }

    public User getUser(String username) {
        User user = userRegistry.getUser(username);

        if (user == null) {
            throw new UserNotFoundException("User not found: " + username);
        }

        return user;
    }

    public List<CommandResult> commandExecute(User user, CommandRequest request) {
        Command command = commandRegistry.createCommand(request.command());
        List<CommandResult> results = command.execute(user);

        return eventsProcessor.process(user, results);
    }

    public List<CommandResult> createNewGame(User user, NewGameRequest request) {
        Command newgameCommand = new NewGameCommand(gameSessionService, request.characterName(), request.type());

        return newgameCommand.execute(user);
    }

    public List<CommandResult> resumeSavedGame(User user, ResumeGameRequest request) {
        Command resumeCommand = new ResumeCommand(gameSessionService, request.filename());

        return resumeCommand.execute(user);
    }

    public List<CommandResult> loadSavedGames(User user) {
        Command loadOptions = commandRegistry.getCommand(LOAD);

        return loadOptions.execute(user);
    }
}
