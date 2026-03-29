package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.characters.statistics.attack.AttackType;

public class Boss extends Enemy {
    private static final EnemyType BOSS = EnemyType.BOSS;
    private static final AttackType DOUBLE_ATTACK = AttackType.DOUBLE;

    public Boss() {
        super(BOSS);
    }

    @Override
    public AttackType attackType() {
        return DOUBLE_ATTACK;
    }
}
