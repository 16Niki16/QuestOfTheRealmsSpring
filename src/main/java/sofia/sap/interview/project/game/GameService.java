package sofia.sap.interview.project.game;

import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.command.CommandFactory;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.events.EventProcessor;
import sofia.sap.interview.project.game.exceptions.UserNotFoundException;
import sofia.sap.interview.project.game.request.CommandRequest;
import sofia.sap.interview.project.game.systems.SystemsStarter;
import sofia.sap.interview.project.game.user.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GameService {
    private final Map<String, User> users = new ConcurrentHashMap<>();

    public GameService() {
        SystemsStarter starter = new SystemsStarter(users.values());
        starter.start();
    }

    public void getOrCreateUser(String username) {
        users.computeIfAbsent(username, User::createUser);
    }

    public User getUser(String username) {
        User user = users.get(username);
        if (user == null) {
            throw new UserNotFoundException("User not found: " + username);
        }
        return user;
    }

    public List<CommandResult> commandExecute(User user, CommandRequest request) {
        Command command = CommandFactory.createCommand(request.command());
        List<CommandResult> results = command.execute(user);
        return EventProcessor.process(user, results);
    }
}
