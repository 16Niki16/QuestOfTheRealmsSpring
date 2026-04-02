package sofia.sap.interview.project.game;

import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.commands.LoadCommand;
import sofia.sap.interview.project.game.command.commands.NewGameCommand;
import sofia.sap.interview.project.game.command.commands.ResumeCommand;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.events.EventProcessor;
import sofia.sap.interview.project.game.exceptions.UserNotFoundException;
import sofia.sap.interview.project.game.exceptions.UsernameAlreadyExistException;
import sofia.sap.interview.project.game.request.CommandRequest;
import sofia.sap.interview.project.game.request.NewGameRequest;
import sofia.sap.interview.project.game.request.ResumeGameRequest;
import sofia.sap.interview.project.game.systems.SystemsStarter;
import sofia.sap.interview.project.game.user.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static sofia.sap.interview.project.game.command.CommandRegistry.createCommand;
import static sofia.sap.interview.project.game.user.User.createUser;

@Service
public class GameService {
    private final Map<String, User> users = new ConcurrentHashMap<>();

    public GameService() {
        SystemsStarter starter = new SystemsStarter(users.values());
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
        Command command = createCommand(request.command());
        List<CommandResult> results = command.execute(user);

        return EventProcessor.process(user, results);
    }

    public List<CommandResult> createNewGame(User user, NewGameRequest request) {
        Command newgameCommand = new NewGameCommand(request.characterName(), request.type());

        return newgameCommand.execute(user);
    }

    public List<CommandResult> resumeSavedGame(User user, ResumeGameRequest request) {
        Command resumeCommand = new ResumeCommand(request.filename());

        return resumeCommand.execute(user);
    }

    public List<CommandResult> loadSavedGames(User user) {
        Command loadOptions = new LoadCommand();

        return loadOptions.execute(user);
    }
}
