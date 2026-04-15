package sofia.sap.interview.project.game.command.commands;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.files.GameRepositoryService;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.information.SaveInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@Component
@AllArgsConstructor
public class SaveCommand implements Command {
    private GameRepositoryService gameRepositoryService;

    @Override
    public List<CommandResult> execute(User user) {
        gameRepositoryService.saveGame(user);

        return List.of(SaveInformation.of(user.getCurrentGameSessionName()));
    }
}
