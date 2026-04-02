package sofia.sap.interview.project.game.command.commands;

import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.information.LoadInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;
@Component
public class LoadCommand implements Command {
    @Override
    public List<CommandResult> execute(User user) {
        List<String> savedGames = user.savedGames();

        return List.of(LoadInformation.of(savedGames));
    }
}
