package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.dto.savegame.data.QuestData;
import sofia.sap.interview.project.game.events.GameEvent;
import sofia.sap.interview.project.game.events.KillEnemyEvent;

public class KillBoss extends QuestBase {
    private static final EnemyType TARGET = EnemyType.BOSS;
    private static final Reward REWARD = Reward.GRAND;

    public KillBoss() {
        super(REWARD);
    }

    @Override
    public QuestType getType() {
        return QuestType.KILL_BOSS;
    }

    @Override
    public String questDescription() {
        return "You need to find and kill the boss!";
    }

    @Override
    public void update(GameEvent event) {
        if (event instanceof KillEnemyEvent e && e.enemy().getType().equals(TARGET)) {
            completeQuest();
        }
    }

    @Override
    public QuestData toSave() {
        return new QuestData(getType(), this.isCompleted(), null);
    }
}
