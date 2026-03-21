package sofia.sap.interview.project;

import sofia.sap.interview.project.game.GameService;
import sofia.sap.interview.project.game.command.CommandFactory;
import sofia.sap.interview.project.game.command.commands.Command;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.events.EventProcessor;
import sofia.sap.interview.project.game.exceptions.NoActiveSessionException;
import sofia.sap.interview.project.game.request.CommandRequest;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class GameRestControllerHelpers {
    public static List<CommandResult> commandResults(String username, CommandRequest request, GameService gameService) {
        User user = gameService.getUser(username);
        if (!user.isActiveSession()) {
            throw new NoActiveSessionException("Create a game before execute a command!");
        }
        Command command = CommandFactory.createCommand(request.command());
        List<CommandResult> results = command.execute(user);
        return EventProcessor.process(user, results);
    }
}
