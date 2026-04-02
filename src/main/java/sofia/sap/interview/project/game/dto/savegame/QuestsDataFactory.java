package sofia.sap.interview.project.game.dto.savegame;

import sofia.sap.interview.project.game.dto.data.QuestData;
import sofia.sap.interview.project.game.dto.data.QuestsData;
import sofia.sap.interview.project.game.quests.Quest;
import sofia.sap.interview.project.game.quests.QuestLog;

import java.util.List;
import java.util.stream.Collectors;

public class QuestsDataFactory {
    public static QuestsData create(QuestLog log) {
        return new QuestsData(createQuest(log.getActiveQuests()),
            createQuest(log.getCompletedQuests()), log.getCollectedXP());
    }

    private static List<QuestData> createQuest(List<Quest> quests) {
        return quests.stream()
            .map(Quest::toSave)
            .collect(Collectors.toList());
    }
}
