package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public class Bandit extends Enemy {

    public Bandit() {
        super(EnemyType.BANDIT);
    }

    @Override
    public String getDamageMessage(int damage) {
        return String.format("The bandit made %d damage to your character!", damage);
    }
}
