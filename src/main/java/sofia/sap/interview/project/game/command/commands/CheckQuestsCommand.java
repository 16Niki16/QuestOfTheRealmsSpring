package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.information.QuestInformation;
import sofia.sap.interview.project.game.quests.QuestLog;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class CheckQuestsCommand implements Command {

    @Override
    public List<CommandResult> execute(User user) {
        QuestLog log = user.getLog();

        return List.of(new ViewResult(new QuestInformation(log.getActiveQuests(), log.getCompletedQuests())));
    }
}
