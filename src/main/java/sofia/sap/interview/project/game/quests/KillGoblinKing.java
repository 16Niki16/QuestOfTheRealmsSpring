package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.dto.data.QuestData;
import sofia.sap.interview.project.game.results.events.GameEvent;
import sofia.sap.interview.project.game.results.events.KillEnemyEvent;

import static sofia.sap.interview.project.game.characters.enemy.type.EnemyType.GOBLIN_KING;
import static sofia.sap.interview.project.game.quests.QuestType.KILL_GOBLIN_KING;
import static sofia.sap.interview.project.game.quests.Reward.MEDIUM;

public class KillGoblinKing extends QuestBase {
    private static final EnemyType TARGET = GOBLIN_KING;
    private static final Reward REWARD = MEDIUM;

    public KillGoblinKing() {
        super(REWARD);
    }

    @Override
    public QuestType getType() {
        return KILL_GOBLIN_KING;
    }

    @Override
    public String questDescription() {
        return "Kill the goblin king!";
    }

    @Override
    public void update(GameEvent event) {
        if (event instanceof KillEnemyEvent e && e.enemyType().equals(TARGET)) {
            completeQuest();
        }
    }

    @Override
    public QuestData toSave() {
        return new QuestData(getType(), this.isCompleted(), null);
    }

}
