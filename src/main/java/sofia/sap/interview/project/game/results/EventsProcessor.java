package sofia.sap.interview.project.game.results;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.gameplay.GameSessionService;
import sofia.sap.interview.project.game.quests.QuestLog;
import sofia.sap.interview.project.game.results.events.GameEvent;
import sofia.sap.interview.project.game.results.events.GameOverEvent;
import sofia.sap.interview.project.game.results.events.GameWonEvent;
import sofia.sap.interview.project.game.results.events.QuestCompletedEvent;
import sofia.sap.interview.project.game.user.User;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EventsProcessor {
    private final GameSessionService gameSessionService;

    public List<CommandResult> process(User user, List<CommandResult> commandResults) {
        if (!user.isActiveSession()) {
            return commandResults;
        }

        List<CommandResult> allResults = new ArrayList<>(commandResults);
        QuestLog questLog = user.getSession().log();

        for (CommandResult result : commandResults) {

            if (result instanceof GameEvent event) {
                boolean questCompleted = questLog.handleEvent(event);

                if (questCompleted) {
                    allResults.add(QuestCompletedEvent.of(questLog.getLastCompletedQuest()));
                }
                if (event instanceof GameOverEvent) {
                    gameSessionService.endGame(user);
                    return allResults;
                }
            }
        }

        if (questLog != null && questLog.areAllQuestsCompleted()) {
            allResults.add(GameWonEvent.of(user.getSession().character(), questLog));
            gameSessionService.endGame(user);
        }

        return allResults;
    }
}
