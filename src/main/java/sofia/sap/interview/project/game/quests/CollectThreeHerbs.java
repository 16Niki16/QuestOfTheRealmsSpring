package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.dto.savegame.data.QuestData;
import sofia.sap.interview.project.game.events.CollectItemsEvent;
import sofia.sap.interview.project.game.events.GameEvent;
import sofia.sap.interview.project.game.items.ItemType;

public class CollectThreeHerbs extends QuestBase {
    private static final ItemType ITEM = ItemType.HEALING_HERB;
    private static final Reward REWARD = Reward.GRAND;
    private static final int NEEDED_HERBS = 3;
    private int numberOfCollectedHerbs;

    public CollectThreeHerbs() {
        super(REWARD);
        this.numberOfCollectedHerbs = 0;
    }

    @Override
    public QuestType getType() {
        return QuestType.COLLECT_THREE_HERBS;
    }

    @Override
    public String questDescription() {
        return "You need to collect 3 herbs!";
    }

    @Override
    public void update(GameEvent event) {
        if (event instanceof CollectItemsEvent e && e.items().containsKey(ITEM)) {
            this.numberOfCollectedHerbs += e.items().get(ITEM);
            if (this.numberOfCollectedHerbs >= NEEDED_HERBS) {
                completeQuest();
            }

        }
    }

    @Override
    public void load(QuestData data) {
        super.load(data);
        this.numberOfCollectedHerbs = data.progress();
    }

    @Override
    public QuestData toSave() {
        return new QuestData(getType(), this.isCompleted(), this.numberOfCollectedHerbs);
    }
}
