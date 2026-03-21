package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.files.EndGame;
import sofia.sap.interview.project.game.quests.QuestLog;
import sofia.sap.interview.project.game.user.User;

import java.util.ArrayList;
import java.util.List;

public class EventProcessor {
    public static List<CommandResult> process(User user, List<CommandResult> commandResults) {
        List<CommandResult> allResults = new ArrayList<>(commandResults);
        QuestLog questLog = user.getLog();
        for (CommandResult result : commandResults) {
            if (result instanceof EventResult eventResult) {
                GameEvent event = eventResult.event();
                boolean questCompleted = questLog.handleEvent(event);

                if (questCompleted) {
                    allResults.add(new EventResult(QuestCompletedEvent.of(questLog.getLastCompletedQuest())));
                    if (questLog.getActiveQuests().isEmpty()) {
                        allResults.add(new EventResult(GameWonEvent.of(user.getSession().character(), questLog)));
                        endGameHelper(user);
                    }
                }
                if (event instanceof CharacterDiedEvent) {
                    endGameHelper(user);
                }
            }
        }
        return allResults;
    }

    private static void endGameHelper(User user) {
        user.endGame();
        EndGame.endGame(user.getUsername());
    }
}
