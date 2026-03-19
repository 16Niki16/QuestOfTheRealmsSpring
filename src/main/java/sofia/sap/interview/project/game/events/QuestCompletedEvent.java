package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.quests.Quest;
import sofia.sap.interview.project.game.quests.QuestType;

public record QuestCompletedEvent(EventType eventType, QuestType type, String description) implements GameEvent {
    public static QuestCompletedEvent of(Quest quest) {
        return new QuestCompletedEvent(EventType.QUEST_COMPLETED, quest.getType(), quest.questDescription());
    }
}
