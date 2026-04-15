package sofia.sap.interview.project.game.command.commands;

import lombok.AllArgsConstructor;
import sofia.sap.interview.project.game.dto.loadgame.LoadedSessionInformation;
import sofia.sap.interview.project.game.files.GameRepositoryService;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.quests.QuestLog;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.information.ResumeInformation;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@AllArgsConstructor
public class ResumeCommand implements Command {
    private final GameRepositoryService gameRepositoryService;
    private final String filename;

    @Override
    public List<CommandResult> execute(User user) {
        LoadedSessionInformation loadedSessionInformation =
                gameRepositoryService.getPreviousGameSession(user, filename);
        GameSession loadedSession = loadedSessionInformation.session();
        QuestLog loadedQuestLog = loadedSessionInformation.log();
        user.createSession(filename, loadedSession, loadedQuestLog);

        return List.of(ResumeInformation.of(loadedSession.getCharacter(), loadedSession.getCampaign().getRoom()));
    }
}
