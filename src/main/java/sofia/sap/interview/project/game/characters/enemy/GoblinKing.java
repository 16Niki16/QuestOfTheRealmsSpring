package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public class GoblinKing extends Enemy {
    public GoblinKing() {
        super(EnemyType.GOBLIN_KING);
    }

    @Override
    public String getDamageMessage(int damage) {
        return String.format("The goblin king attack caused %d damage!", damage);
    }
}
