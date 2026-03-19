package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public class Goblin extends Enemy {
    public Goblin() {
        super(EnemyType.GOBLIN);
    }

    @Override
    public String getDamageMessage(int damage) {
        return String.format("The goblin made %d damage!", damage);
    }

}
