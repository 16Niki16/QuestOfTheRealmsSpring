package sofia.sap.interview.project.game;

import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.command.CommandRegistry;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.commands.LoadCommand;
import sofia.sap.interview.project.game.command.commands.ResumeCommand;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.events.EventProcessor;
import sofia.sap.interview.project.game.events.NewGameEvent;
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

import static sofia.sap.interview.project.game.command.CommandRegistry.*;

@Service
public class GameService {
    private final Map<String, User> users = new ConcurrentHashMap<>();

    public GameService() {
        SystemsStarter starter = new SystemsStarter(users.values());
        starter.start();
    }

    public void registerUser(String username) {
        User existing = users.putIfAbsent(username, User.createUser(username));

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

    public NewGameEvent createNewGame(User user, NewGameRequest request) {
        user.createNewGame(request.characterName(), request.type());

        return NewGameEvent.of(user.getSession().getCharacter());
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
