package sofia.sap.interview.project.game.characters.ally.type;

import sofia.sap.interview.project.game.characters.attack.AttackRange;

public enum AllyCharacterType {
    MAGE(80, 120, new AttackRange(10, 20), 15),
    WARRIOR(100, 100, new AttackRange(10, 30), 10),
    ROGUE(110, 90, new AttackRange(5, 20), 10);
    private final int health;
    private final int mana;
    private final AttackRange attackRange;
    private final int manaCost;

    AllyCharacterType(int health, int mana, AttackRange attackRange, int manaCost) {
        this.health = health;
        this.mana = mana;
        this.attackRange = attackRange;
        this.manaCost = manaCost;
    }

    public int getHealth() {
        return this.health;
    }

    public int getMana() {
        return this.mana;
    }

    public AttackRange getAttackRange() {
        return this.attackRange;
    }

    public int getManaCost() {
        return this.manaCost;
    }
}
