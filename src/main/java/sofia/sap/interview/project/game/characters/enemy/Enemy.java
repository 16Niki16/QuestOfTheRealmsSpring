package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.statistics.EnemyStatistics;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public abstract class Enemy {
    private final EnemyType type;
    private final EnemyStatistics enemyStats;

    public Enemy(EnemyType type) {
        this.enemyStats = new EnemyStatistics(type);
        this.type = type;
    }

    public EnemyType getType() {
        return this.type;
    }

    public int attackDamage() {
        return enemyStats.attack();
    }

    public int health() {
        return enemyStats.getHealth();
    }

    public boolean defendAgainstAllyCharacter(int damage) {
        return this.enemyStats.decreaseHealth(damage);
    }

    public abstract String getDamageMessage(int damage);

    public void load(int health) {
        this.enemyStats.updateHealth(health);
    }
}
