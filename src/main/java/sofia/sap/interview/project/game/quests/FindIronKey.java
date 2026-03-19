package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.dto.savegame.data.QuestData;
import sofia.sap.interview.project.game.events.CollectSpecialItemEvent;
import sofia.sap.interview.project.game.events.GameEvent;
import sofia.sap.interview.project.game.map.room.SpecialItem;

public class FindIronKey extends QuestBase {
    private static final SpecialItem SPECIAL_ITEM = SpecialItem.IRON_KEY;
    private static final Reward REWARD = Reward.BIG;

    public FindIronKey() {
        super(REWARD);
    }

    @Override
    public QuestType getType() {
        return QuestType.FIND_IRON_KEY;
    }

    @Override
    public String questDescription() {
        return "Your quest is to find the iron key!";
    }

    @Override
    public void update(GameEvent event) {
        if (event instanceof CollectSpecialItemEvent e && e.item().equals(SPECIAL_ITEM)) {
            completeQuest();
        }
    }

    @Override
    public QuestData toSave() {
        return new QuestData(getType(), this.isCompleted(), null);
    }
}
