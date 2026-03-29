package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.characters.statistics.attack.AttackType;

public class Bandit extends Enemy {
    private static final EnemyType BANDIT = EnemyType.BANDIT;
    private static final AttackType CRITICAL_ATTACK = AttackType.CRITICAL;

    public Bandit() {
        super(BANDIT);
    }

    @Override
    public AttackType attackType() {
        return CRITICAL_ATTACK;
    }
}
