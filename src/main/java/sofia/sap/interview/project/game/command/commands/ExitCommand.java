package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.information.ExitInformation;
import sofia.sap.interview.project.game.information.QuestInformation;
import sofia.sap.interview.project.game.quests.QuestLog;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class ExitCommand implements Command {
    @Override
    public List<CommandResult> execute(User user) {
        user.save();
        String filename = user.getCurrentGameSessionName();
        QuestLog log = user.getLog();
        user.exitGame();
        return List.of(
            QuestInformation.of(log),
            new ExitInformation(filename));
    }
}
