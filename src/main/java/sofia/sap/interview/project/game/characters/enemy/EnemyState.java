package sofia.sap.interview.project.game.characters.enemy;

import java.time.Duration;

public class EnemyState {
    private static final Duration COOLDOWN_SECONDS = Duration.ofSeconds(8);
    private long lastAttack;

    public EnemyState() {
        this.lastAttack = System.currentTimeMillis();
    }

    public boolean canAttack() {
        return COOLDOWN_SECONDS.compareTo(Duration.ofSeconds(System.currentTimeMillis() - lastAttack)) < 0;
    }

    public void attacked() {
        this.lastAttack = System.currentTimeMillis();
    }
}
