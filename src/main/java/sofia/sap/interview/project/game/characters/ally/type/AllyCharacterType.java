package sofia.sap.interview.project.game.characters.ally.type;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.attack.AttackRange;

@Getter
public enum AllyCharacterType {
    MAGE(80, 100, new AttackRange(1, 2), 15),
    WARRIOR(90, 100, new AttackRange(10, 30), 10),
    ROGUE(100, 90, new AttackRange(5, 20), 10);

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

}
