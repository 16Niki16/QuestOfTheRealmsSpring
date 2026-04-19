package sofia.sap.interview.project.game.items.consumable;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.items.ItemType;

import static sofia.sap.interview.project.game.items.ItemType.HEALING_HERB;

public class HealingHerb implements Consumable {
    private static final int EFFECT = 15;

    @Override
    public ItemType getType() {
        return HEALING_HERB;
    }

    @Override
    public int getEffect() {
        return EFFECT;
    }

    @Override
    public void consume(Character character) {
        character.heal(EFFECT);
    }

}
