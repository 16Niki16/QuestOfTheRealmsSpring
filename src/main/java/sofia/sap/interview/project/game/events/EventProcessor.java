package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.command.CommandResult;
import sofia.sap.interview.project.game.quests.QuestLog;
import sofia.sap.interview.project.game.user.User;

import java.util.ArrayList;
import java.util.List;

public class EventProcessor {
    public static List<CommandResult> process(User user, List<CommandResult> commandResults) {
        List<CommandResult> allResults = new ArrayList<>(commandResults);
        QuestLog questLog = user.getLog();

        for (CommandResult result : commandResults) {

            if (result instanceof GameEvent event) {
                boolean questCompleted = questLog.handleEvent(event);

                if (questCompleted) {
                    allResults.add(QuestCompletedEvent.of(questLog.getLastCompletedQuest()));

                    if (questLog.getActiveQuests().isEmpty()) {
                        allResults.add(GameWonEvent.of(user.getSession().getCharacter(), questLog));
                        user.endGame();
                    }
                }
                if (event instanceof GameOverEvent) {
                    user.endGame();
                }
            }
        }
        return allResults;
    }
}
