package sofia.sap.interview.project.game.items;

import sofia.sap.interview.project.game.characters.ally.Character;

public class IronDagger implements Gear {
    private static final int EFFECT = 8;

    @Override
    public ItemType getType() {
        return ItemType.IRON_DAGGER;
    }

    @Override
    public int getEffect() {
        return EFFECT;
    }

    @Override
    public void equip(Character character) {
        character.increaseAttackDamage(EFFECT);
    }

    @Override
    public void unequip(Character character) {
        character.decreaseAttackDamage(EFFECT);
    }

}
