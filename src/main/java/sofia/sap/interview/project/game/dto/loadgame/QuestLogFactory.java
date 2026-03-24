package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.dto.savegame.data.QuestData;
import sofia.sap.interview.project.game.dto.savegame.data.QuestsData;
import sofia.sap.interview.project.game.quests.Quest;
import sofia.sap.interview.project.game.quests.QuestLog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestLogFactory {
    public static QuestLog createQuestLog(QuestsData data) {
        List<QuestData> active = data.active();
        List<QuestData> completed = data.completed();

        List<Quest> activeQuests = transform(active);
        List<Quest> completedQuests = transform(completed);

        return new QuestLog(activeQuests, completedQuests, data.collectedXP());
    }

    private static List<Quest> transform(List<QuestData> quests) {
        return quests.stream()
            .map(QuestFactory::create)
            .collect(Collectors.toCollection(ArrayList::new));
    }
}
