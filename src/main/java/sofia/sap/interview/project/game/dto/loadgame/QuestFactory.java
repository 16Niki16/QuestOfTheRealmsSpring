package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.dto.savegame.data.QuestData;
import sofia.sap.interview.project.game.quests.Quest;

import static sofia.sap.interview.project.game.quests.QuestRegistry.createQuest;

public class QuestFactory {
    public static Quest create(QuestData data) {
        Quest quest = createQuest(data.type());
        quest.load(data);
        return quest;
    }
}
