package sofia.sap.interview.project.game.command.commands;

import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.quests.QuestLog;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.information.QuestInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@Component
public class CheckQuestsCommand implements Command {

    @Override
    public List<CommandResult> execute(User user) {
        QuestLog questLog = user.getSession().log();

        return List.of(QuestInformation.of(questLog));
    }
}
