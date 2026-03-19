package sofia.sap.interview.project.game.characters.enemy.type;

import sofia.sap.interview.project.game.characters.attack.AttackRange;
import sofia.sap.interview.project.game.exceptions.EnemyTypeNotAvailableException;

public enum EnemyType {
    BANDIT("bandit", 20, new AttackRange(5, 10, 0)),

    BOSS("boss", 40, new AttackRange(10, 15, 0)),

    GOBLIN("goblin", 20, new AttackRange(3, 8, 0)),
    GOBLIN_KING("goblin king", 100, new AttackRange(10, 20, 0));
    private final String type;
    private final int health;
    private final AttackRange attackRange;

    EnemyType(String type, int health, AttackRange attackRange) {
        this.attackRange = attackRange;
        this.health = health;
        this.type = type;
    }

    public String getName() {
        return this.type;
    }

    public int getHealth() {
        return this.health;
    }

    public AttackRange getAttackRange() {
        return this.attackRange;
    }

    public static EnemyType getByName(String name) {

        for (EnemyType enemyType : values()) {
            if (enemyType.type.equals(name)) {
                return enemyType;
            }
        }
        throw new EnemyTypeNotAvailableException("The provided enemy name is not in the list!");
    }
}
