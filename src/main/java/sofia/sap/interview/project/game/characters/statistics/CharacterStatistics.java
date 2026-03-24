package sofia.sap.interview.project.game.characters.statistics;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.characters.statistics.attack.AttackRange;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class CharacterStatistics extends BaseStatistics {
    private final AtomicInteger mana;
    @Getter
    private final int manaCost;

    public CharacterStatistics(int health, AttackRange attackRange, int mana, int manaCost) {
        super(health, attackRange);
        this.mana = new AtomicInteger(mana);
        this.manaCost = manaCost;
    }

    public static CharacterStatistics createNewCharacter(AllyCharacterType type) {
        return new CharacterStatistics(type.getHealth(), type.getAttackRange(),
            type.getMana(), type.getManaCost());
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
        boolean enoughMana = decreaseMana(this.manaCost);
        if (enoughMana) {
            return ThreadLocalRandom.current().nextInt(getAttackRange().minDamage(), getAttackRange().maxDamage() + 1);
        }
        return 0;
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

    public void regenerate(int amount) {
        increaseHealth(amount);
        increaseMana(amount);
    }
}
