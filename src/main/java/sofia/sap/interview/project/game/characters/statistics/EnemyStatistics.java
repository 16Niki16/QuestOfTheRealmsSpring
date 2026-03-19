package sofia.sap.interview.project.game.characters.statistics;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

import java.util.concurrent.ThreadLocalRandom;

public class EnemyStatistics extends BaseStatistics {

    public EnemyStatistics(EnemyType type) {
        super(type.getHealth(), type.getAttackRange());
    }

    @Override
    public int attack() {
        return ThreadLocalRandom.current().nextInt(getAttackRange().minDamage(), getAttackRange().maxDamage() + 1);
    }
}
