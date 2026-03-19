package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.dto.savegame.data.QuestData;
import sofia.sap.interview.project.game.events.GameEvent;

public interface Quest {
    QuestType getType();

    String questDescription();

    boolean isCompleted();

    void update(GameEvent event);

    Reward getReward();

    QuestData toSave();

    void load(QuestData data);
}
