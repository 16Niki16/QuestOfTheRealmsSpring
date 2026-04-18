package sofia.sap.interview.project.game.command.commands;

import lombok.AllArgsConstructor;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.gameplay.GameSessionService;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.information.ResumeInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@AllArgsConstructor
public class ResumeCommand implements Command {
    private final GameSessionService gameSessionService;
    private final String filename;

    @Override
    public List<CommandResult> execute(User user) {
        gameSessionService.resumeGame(user, filename);
        GameSession loadedSession = user.getSession();

        return List.of(ResumeInformation.of(loadedSession.character(), loadedSession.campaign().getRoom()));
    }
}
