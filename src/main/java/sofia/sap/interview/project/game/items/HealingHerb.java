package sofia.sap.interview.project.game.items;

import sofia.sap.interview.project.game.characters.ally.Character;

public class HealingHerb implements Consumable {
    private static final int EFFECT = 15;

    @Override
    public ItemType getType() {
        return ItemType.HEALING_HERB;
    }

    @Override
    public int getEffect() {
        return EFFECT;
    }

    @Override
    public void consume(Character character) {
        character.heal(EFFECT);
    }

    @Override
    public String itemMessage() {
        return String.format("You have been healed for %d health!", EFFECT);
    }

}
