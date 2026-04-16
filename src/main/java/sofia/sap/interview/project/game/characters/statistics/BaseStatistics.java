package sofia.sap.interview.project.game.characters.statistics;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.statistics.attack.AttackRange;

@Getter
public abstract class BaseStatistics implements Statistics {
    protected static final int MAX_STAT = 100;
    protected static final int MIN_STAT = 0;
    @Getter
    private int health;
    private AttackRange attackRange;

    public BaseStatistics(int health, AttackRange attackRange) {
        this.attackRange = attackRange;
        this.health = health;
    }

    public void updateHealth(int health) {
        this.health = health;
    }

    public boolean isDead() {
        return health <= MIN_STAT;
    }

    protected void setAttackRange(AttackRange attackRange) {
        this.attackRange = attackRange;
    }

    @Override
    public void decreaseHealth(int amount) {
        health = Math.max(health - amount, MIN_STAT);
    }

    @Override
    public void increaseHealth(int amount) {
        health = Math.min(health + amount, MAX_STAT);
    }

    @Override
    public abstract int attack();
}
