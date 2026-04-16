package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.dto.data.QuestData;
import sofia.sap.interview.project.game.results.events.GameEvent;
import sofia.sap.interview.project.game.results.events.KillEnemyEvent;

import static sofia.sap.interview.project.game.characters.enemy.type.EnemyType.*;
import static sofia.sap.interview.project.game.quests.QuestType.*;
import static sofia.sap.interview.project.game.quests.Reward.*;

public class KillBoss extends QuestBase {
    private static final EnemyType TARGET = BOSS;
    private static final Reward REWARD = GRAND;

    public KillBoss() {
        super(REWARD);
    }

    @Override
    public QuestType getType() {
        return KILL_BOSS;
    }

    @Override
    public String questDescription() {
        return "You need to find and kill the boss!";
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
