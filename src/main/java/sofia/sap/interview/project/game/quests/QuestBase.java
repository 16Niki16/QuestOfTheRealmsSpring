package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.dto.savegame.data.QuestData;
import sofia.sap.interview.project.game.events.GameEvent;

public abstract class QuestBase implements Quest {
    private final Reward reward;
    private boolean completed;

    public QuestBase(Reward reward) {
        this.reward = reward;
        this.completed = false;
    }

    @Override
    public abstract String questDescription();

    @Override
    public boolean isCompleted() {
        return this.completed;
    }

    protected void completeQuest() {
        completed = true;
    }

    @Override
    public abstract void update(GameEvent event);

    @Override
    public Reward getReward() {
        return this.reward;
    }

    @Override
    public void load(QuestData data) {
        this.completed = data.completed();
    }

    @Override
    public abstract QuestData toSave();
}
