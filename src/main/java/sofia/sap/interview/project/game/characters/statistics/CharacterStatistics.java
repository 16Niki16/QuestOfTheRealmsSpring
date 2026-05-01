package sofia.sap.interview.project.game.characters.statistics;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.statistics.attack.AttackRange;

import java.util.concurrent.ThreadLocalRandom;

@Getter
public class CharacterStatistics extends BaseStatistics {
    private static final int NOT_ENOUGH_MANA = 0;
    private int mana;
    private final int manaCost;

    public CharacterStatistics(int health, AttackRange attackRange, int mana, int manaCost) {
        super(health, attackRange);
        this.mana = mana;
        this.manaCost = manaCost;
    }

    public boolean decreaseMana(int amount) {
        if (amount > mana) {
            return false;
        }

        mana -= amount;
        return true;
    }

    public void increaseMana(int amount) {
        mana = Math.min(mana + amount, MAX_STAT);
    }

    @Override
    public int attack() {
        boolean enoughMana = decreaseMana(this.manaCost);

        if (enoughMana) {
            return ThreadLocalRandom.current().nextInt(getAttackRange().minDamage(), getAttackRange().maxDamage() + 1);
        }

        return NOT_ENOUGH_MANA;
    }

    public void increaseAttackRange(int amount) {
        int minDamage = this.getAttackRange().minDamage() + amount;
        int maxDamage = this.getAttackRange().maxDamage() + amount;

        setAttackRange(new AttackRange(minDamage, maxDamage));
    }

    public void decreaseAttackRange(int amount) {
        int min = Math.max(0, getAttackRange().minDamage() - amount);
        int max = Math.max(min, getAttackRange().maxDamage() - amount);

        setAttackRange(new AttackRange(min, max));
    }

    public boolean needsRegen() {
        return getHealth() < MAX_STAT || this.mana < MAX_STAT;
    }

    public void regenerate(int amount) {
        increaseHealth(amount);
        increaseMana(amount);
    }
}
