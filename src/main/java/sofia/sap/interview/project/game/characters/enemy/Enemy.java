package sofia.sap.interview.project.game.characters.enemy;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.statistics.EnemyStatistics;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

@Getter
public abstract class Enemy {

    private final EnemyType type;
    private final EnemyStatistics enemyStats;

    public Enemy(EnemyType type) {
        this.enemyStats = new EnemyStatistics(type);
        this.type = type;
    }

    public int attackDamage() {
        return enemyStats.attack();
    }

    public int health() {
        return enemyStats.getHealth();
    }

    public void defendAgainstAllyCharacter(int damage) {
        this.enemyStats.decreaseHealth(damage);
    }

    public abstract String getDamageMessage(int damage);

    public void load(int health) {
        this.enemyStats.updateHealth(health);
    }
}
