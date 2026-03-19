package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.dto.savegame.data.QuestData;
import sofia.sap.interview.project.game.quests.Quest;

public class QuestFactory {
    public static Quest create(QuestData data) {
        Quest quest = data.type().create();
        quest.load(data);
        return quest;
    }
}
