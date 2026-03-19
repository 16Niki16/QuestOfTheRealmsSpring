package sofia.sap.interview.project.game.characters.enemy;

public class EnemyState {
    private static final int COOLDOWN = 8000;
    private long lastAttack;

    public EnemyState() {
        this.lastAttack = System.currentTimeMillis();
    }

    public boolean canAttack() {
        return System.currentTimeMillis() - lastAttack >= COOLDOWN;
    }

    public void attacked() {
        this.lastAttack = System.currentTimeMillis();
    }
}
