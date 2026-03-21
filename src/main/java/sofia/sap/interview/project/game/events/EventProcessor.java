package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.files.EndGame;
import sofia.sap.interview.project.game.quests.QuestLog;
import sofia.sap.interview.project.game.user.User;

import java.util.ArrayList;
import java.util.List;

public class EventProcessor {
    public static List<CommandResult> process(User user, List<CommandResult> results) {
        List<CommandResult> allResults = new ArrayList<>(results);
        QuestLog log = user.getLog();
        for (CommandResult result : results) {
            if (result instanceof EventResult eventResult) {
                GameEvent event = eventResult.event();
                boolean questCompleted = log.handleEvent(event);

                if (questCompleted) {
                    allResults.add(new EventResult(QuestCompletedEvent.of(log.getLastCompletedQuest())));
                }

                if (event instanceof CharacterDiedEvent) {
                    user.endGame();
                    EndGame.endGame(user.getUsername());
                }
            }
        }
        return allResults;
    }
}
