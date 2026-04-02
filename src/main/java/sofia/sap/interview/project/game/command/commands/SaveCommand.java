package sofia.sap.interview.project.game.command.commands;

import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.information.SaveInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;
@Component
public class SaveCommand implements Command {
    @Override
    public List<CommandResult> execute(User user) {
        user.save();

        return List.of(SaveInformation.of(user.getCurrentGameSessionName()));
    }
}
