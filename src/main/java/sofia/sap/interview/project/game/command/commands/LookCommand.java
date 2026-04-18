package sofia.sap.interview.project.game.command.commands;

import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@Component
public class LookCommand implements Command {
    @Override
    public List<CommandResult> execute(User user) {
        GameSession session = user.getSession();

        synchronized (user) {
            return session.campaign().lookAround();
        }
    }
}
