package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.characters.statistics.attack.AttackType;

public class GoblinKing extends Enemy {
    private static final EnemyType GOBLIN_KING = EnemyType.GOBLIN_KING;
    private static final AttackType POISONOUS_ATTACK = AttackType.POISONOUS;

    public GoblinKing() {
        super(GOBLIN_KING);
    }

    @Override
    public AttackType attackType() {
        return POISONOUS_ATTACK;
    }
}
