package sofia.sap.interview.project.game.command.commands;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.files.GameRepositoryService;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.information.LoadInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@Component
@AllArgsConstructor
public class LoadCommand implements Command {
    private final GameRepositoryService gameRepositoryService;

    @Override
    public List<CommandResult> execute(User user) {
        List<String> savedGames = gameRepositoryService.getPreviousGames(user);

        return List.of(LoadInformation.of(savedGames));
    }
}
