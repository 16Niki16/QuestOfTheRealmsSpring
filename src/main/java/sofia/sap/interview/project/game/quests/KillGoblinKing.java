package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.dto.savegame.data.QuestData;
import sofia.sap.interview.project.game.events.GameEvent;
import sofia.sap.interview.project.game.events.KillEnemyEvent;

public class KillGoblinKing extends QuestBase {
    private static final EnemyType TARGET = EnemyType.GOBLIN_KING;
    private static final Reward REWARD = Reward.MEDIUM;

    public KillGoblinKing() {
        super(REWARD);
    }

    @Override
    public QuestType getType() {
        return QuestType.KILL_GOBLIN_KING;
    }

    @Override
    public String questDescription() {
        return "Kill the goblin king!";
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
