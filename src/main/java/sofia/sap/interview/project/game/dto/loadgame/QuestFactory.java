package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.dto.savegame.data.QuestData;
import sofia.sap.interview.project.game.quests.Quest;
import sofia.sap.interview.project.game.quests.QuestList;

public class QuestFactory {
    public static Quest create(QuestData data) {
        Quest quest = QuestList.create(data.type());
        quest.load(data);
        return quest;
    }
}
