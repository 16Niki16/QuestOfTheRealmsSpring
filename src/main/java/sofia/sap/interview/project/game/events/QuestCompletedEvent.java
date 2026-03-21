package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.quests.Quest;
import sofia.sap.interview.project.game.quests.QuestType;
import sofia.sap.interview.project.game.quests.Reward;

public record QuestCompletedEvent(EventType eventType, QuestType type,
                                  String questDescription, Reward questReward) implements GameEvent {
    public static QuestCompletedEvent of(Quest quest) {
        return new QuestCompletedEvent(EventType.QUEST_COMPLETED, quest.getType(),
                quest.questDescription(), quest.getReward());
    }
}
