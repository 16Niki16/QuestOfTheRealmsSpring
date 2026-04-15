package sofia.sap.interview.project.game.command.commands;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.files.GameRepositoryService;
import sofia.sap.interview.project.game.quests.QuestLog;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.information.ExitInformation;
import sofia.sap.interview.project.game.results.information.QuestInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@Component
@AllArgsConstructor
public class ExitCommand implements Command {
    private final GameRepositoryService gameRepositoryService;

    @Override
    public List<CommandResult> execute(User user) {
        String filename = user.getCurrentGameSessionName();
        QuestLog log = user.getLog();
        gameRepositoryService.saveGame(user);
        user.clearSession();

        return List.of(
                QuestInformation.of(log),
                ExitInformation.of(filename));
    }
}
