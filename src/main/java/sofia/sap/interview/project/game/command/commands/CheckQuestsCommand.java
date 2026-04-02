package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.information.QuestInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class CheckQuestsCommand implements Command {

    @Override
    public List<CommandResult> execute(User user) {
        return List.of(QuestInformation.of(user.getLog()));
    }
}
