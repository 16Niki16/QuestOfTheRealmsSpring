package sofia.sap.interview.project.game.command.commands;

import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.quests.QuestLog;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.information.ExitInformation;
import sofia.sap.interview.project.game.results.information.QuestInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@Component
public class ExitCommand implements Command {
    @Override
    public List<CommandResult> execute(User user) {
        user.save();
        String filename = user.getCurrentGameSessionName();
        QuestLog log = user.getLog();
        user.exitGame();

        return List.of(
                QuestInformation.of(log),
                ExitInformation.of(filename));
    }
}
