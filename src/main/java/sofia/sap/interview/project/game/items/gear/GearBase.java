package sofia.sap.interview.project.game.items.gear;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.items.ItemType;

public abstract class GearBase implements Gear {
    @Override
    public abstract GearType getGearType();

    @Override
    public abstract ItemType getType();

    @Override
    public abstract int getEffect();

    @Override
    public void equip(Character character) {
        character.increaseAttackDamage(getEffect());
    }

    @Override
    public void unequip(Character character) {
        character.decreaseAttackDamage(getEffect());
    }
}
