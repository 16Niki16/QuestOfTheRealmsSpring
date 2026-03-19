package sofia.sap.interview.project.game.items;

import sofia.sap.interview.project.game.characters.ally.Character;

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

    @Override
    public String itemMessage() {
        return String.format("Your potion provided you with %d mana!", EFFECT);
    }
}
