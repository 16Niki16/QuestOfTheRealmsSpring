package sofia.sap.interview.project.game.characters.statistics;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.characters.attack.AttackRange;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class CharacterStatistics extends BaseStatistics {
    private final AtomicInteger mana;

    public CharacterStatistics(AllyCharacterType type) {
        super(type.getHealth(), type.getAttackRange());
        this.mana = new AtomicInteger(type.getMana());
    }

    public CharacterStatistics(int health, AttackRange attackRange, int mana) {
        super(health, attackRange);
        this.mana = new AtomicInteger(mana);
    }

    public int getMana() {
        return this.mana.get();
    }

    public boolean decreaseMana(int amount) {
        int prev = mana.getAndUpdate(current ->
                current >= amount ? current - amount : current
        );

        return prev >= amount;
    }

    public void increaseMana(int amount) {
        this.mana.updateAndGet(h -> Math.min(h + amount, MAX_STAT));
    }

    @Override
    public int attack() {
        boolean enoughMana = decreaseMana(getAttackRange().manaCost());
        if (enoughMana) {
            return ThreadLocalRandom.current().nextInt(getAttackRange().minDamage(), getAttackRange().maxDamage() + 1);
        }
        return 0;
    }

    public void increaseAttackRange(int amount) {
        int minDamage = this.getAttackRange().minDamage() + amount;
        int maxDamage = this.getAttackRange().maxDamage() + amount;

        setAttackRange(new AttackRange(minDamage, maxDamage, getAttackRange().manaCost()));
    }

    public void decreaseAttackRange(int amount) {
        int min = Math.max(0, getAttackRange().minDamage() - amount);
        int max = Math.max(min, getAttackRange().maxDamage() - amount);

        setAttackRange(new AttackRange(min, max, getAttackRange().manaCost()));
    }

    public void regenerate(int amount) {
        increaseHealth(amount);
        increaseMana(amount);
    }
}
