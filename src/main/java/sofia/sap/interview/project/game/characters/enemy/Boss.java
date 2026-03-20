package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public class Boss extends Enemy {
    public Boss() {
        super(EnemyType.BOSS);
    }

    @Override
    public String getDamageMessage(int damage) {
        return String.format("The boss caused %d damage!", damage);
    }
}
