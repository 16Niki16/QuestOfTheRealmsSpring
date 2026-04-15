package sofia.sap.interview.project.game;

import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.command.CommandRegistry;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.commands.NewGameCommand;
import sofia.sap.interview.project.game.exceptions.UserNotFoundException;
import sofia.sap.interview.project.game.exceptions.UsernameAlreadyExistException;
import sofia.sap.interview.project.game.gameplay.GameSessionService;
import sofia.sap.interview.project.game.request.CommandRequest;
import sofia.sap.interview.project.game.request.NewGameRequest;
import sofia.sap.interview.project.game.request.ResumeGameRequest;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.events.EventProcessor;
import sofia.sap.interview.project.game.systems.SystemsStarter;
import sofia.sap.interview.project.game.user.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static sofia.sap.interview.project.game.command.CommandOption.LOAD;
import static sofia.sap.interview.project.game.command.CommandOption.RESUME;
import static sofia.sap.interview.project.game.user.User.createUser;

@Service
public class GameService {
    private final CommandRegistry commandRegistry;
    private final GameSessionService gameSessionService;
    private final Map<String, User> users = new ConcurrentHashMap<>();

    public GameService(CommandRegistry commandRegistry, GameSessionService gameSessionService) {
        SystemsStarter starter = new SystemsStarter(users.values());
        this.commandRegistry = commandRegistry;
        this.gameSessionService = gameSessionService;
        starter.start();
    }

    public void registerUser(String username) {
        User existing = users.putIfAbsent(username, createUser(username));

        if (existing != null) {
            throw new UsernameAlreadyExistException("Username already taken: " + username);
        }
    }

    public User getUser(String username) {
        User user = users.get(username);

        if (user == null) {
            throw new UserNotFoundException("User not found: " + username);
        }

        return user;
    }

    public List<CommandResult> commandExecute(User user, CommandRequest request) {
        Command command = commandRegistry.createCommand(request.command());
        List<CommandResult> results = command.execute(user);

        return EventProcessor.process(user, results);
    }

    public List<CommandResult> createNewGame(User user, NewGameRequest request) {
        Command newgameCommand = new NewGameCommand(gameSessionService, request.characterName(), request.type());

        return newgameCommand.execute(user);
    }

    public List<CommandResult> resumeSavedGame(User user, ResumeGameRequest request) {
        Command resumeCommand = commandRegistry.getCommand(RESUME, request.filename());

        return resumeCommand.execute(user);
    }

    public List<CommandResult> loadSavedGames(User user) {
        Command loadOptions = commandRegistry.getCommand(LOAD);

        return loadOptions.execute(user);
    }
}
