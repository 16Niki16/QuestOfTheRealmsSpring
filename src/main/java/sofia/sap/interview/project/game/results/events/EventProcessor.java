package sofia.sap.interview.project.game.results.events;

import sofia.sap.interview.project.game.quests.QuestLog;
import sofia.sap.interview.project.game.results.CommandResult;
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
                        user.clearSession();
                    }
                }
                if (event instanceof GameOverEvent) {
                    user.clearSession();
                }
            }
        }
        return allResults;
    }
}
