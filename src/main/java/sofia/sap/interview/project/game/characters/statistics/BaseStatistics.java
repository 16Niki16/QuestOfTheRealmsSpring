package sofia.sap.interview.project.game.characters.statistics;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.statistics.attack.AttackRange;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseStatistics implements Statistics {
    protected static final int MAX_STAT = 100;
    protected static final int MIN_STAT = 0;
    private final AtomicInteger health;
    @Getter
    private AttackRange attackRange;

    public BaseStatistics(int health, AttackRange attackRange) {
        this.attackRange = attackRange;
        this.health = new AtomicInteger(health);
    }

    public int getHealth() {
        return this.health.get();
    }

    public void updateHealth(int health) {
        this.health.set(health);
    }

    public boolean isDead() {
        return health.get() <= MIN_STAT;
    }

    protected void setAttackRange(AttackRange attackRange) {
        this.attackRange = attackRange;
    }

    @Override
    public void decreaseHealth(int amount) {
        health.updateAndGet(currentHealth -> Math.max(currentHealth - amount, 0));
    }

    @Override
    public void increaseHealth(int amount) {
        health.updateAndGet(currentHealth -> Math.min(currentHealth + amount, MAX_STAT));
    }

    @Override
    public abstract int attack();
}
