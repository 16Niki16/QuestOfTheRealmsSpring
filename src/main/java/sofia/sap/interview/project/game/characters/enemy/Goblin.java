package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.characters.statistics.attack.AttackType;

public class Goblin extends Enemy {
    private static final EnemyType GOBLIN = EnemyType.GOBLIN;
    private static final AttackType NORMAL_ATTACK = AttackType.NORMAL;

    public Goblin() {
        super(GOBLIN);
    }

    @Override
    public AttackType attackType() {
        return NORMAL_ATTACK;
    }
}
