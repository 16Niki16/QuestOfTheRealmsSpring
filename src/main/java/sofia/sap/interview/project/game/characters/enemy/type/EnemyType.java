package sofia.sap.interview.project.game.characters.enemy.type;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.statistics.attack.AttackRange;

@Getter
public enum EnemyType {
    BANDIT("bandit", 20, new AttackRange(5, 10)),

    BOSS("boss", 40, new AttackRange(10, 15)),

    GOBLIN("goblin", 20, new AttackRange(3, 8)),
    GOBLIN_KING("goblin king", 100, new AttackRange(10, 20));
    private final String name;
    private final int health;
    private final AttackRange attackRange;

    EnemyType(String name, int health, AttackRange attackRange) {
        this.attackRange = attackRange;
        this.health = health;
        this.name = name;
    }

}
