package sofia.sap.interview.project.game.items.consumable;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.items.ItemType;

public class ManaPotion implements Consumable {
    private static final int EFFECT = 10;

    @Override
    public ItemType getType() {
        return ItemType.MANA_POTION;
    }

    @Override
    public int getEffect() {
        return EFFECT;
    }

    @Override
    public void consume(Character character) {
        character.restoreMana(EFFECT);
    }
}
