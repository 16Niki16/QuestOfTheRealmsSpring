package sofia.sap.interview.project.game.characters.statistics;

import sofia.sap.interview.project.game.characters.statistics.attack.AttackRange;

import java.util.concurrent.ThreadLocalRandom;

public class EnemyStatistics extends BaseStatistics {

    public EnemyStatistics(int health, AttackRange attackRange) {
        super(health, attackRange);
    }

    @Override
    public int attack() {
        return ThreadLocalRandom.current().nextInt(getAttackRange().minDamage(), getAttackRange().maxDamage() + 1);
    }
}
