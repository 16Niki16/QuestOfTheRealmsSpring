package sofia.sap.interview.project.game.dto.events;

import sofia.sap.interview.project.game.quests.Quest;
import sofia.sap.interview.project.game.quests.QuestType;

public record QuestDTO(QuestType questType, String questDescription) {
    public static QuestDTO of(Quest quest) {
        return new QuestDTO(quest.getType(), quest.questDescription());
    }
}
