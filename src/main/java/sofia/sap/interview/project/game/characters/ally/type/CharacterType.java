package sofia.sap.interview.project.game.characters.ally.type;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.statistics.attack.AttackRange;

@Getter
public enum CharacterType {
    MAGE(100, 100, new AttackRange(6, 7), 50),
    WARRIOR(100, 100, new AttackRange(2, 4), 8),
    ROGUE(100, 100, new AttackRange(3, 5), 10);

    private final int health;
    private final int mana;
    private final AttackRange attackRange;
    private final int manaCost;

    CharacterType(int health, int mana, AttackRange attackRange, int manaCost) {
        this.health = health;
        this.mana = mana;
        this.attackRange = attackRange;
        this.manaCost = manaCost;
    }

}
