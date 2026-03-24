package sofia.sap.interview.project.game.items.gear;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.items.Item;

public interface Gear extends Item {
    GearType getGearType();

    void equip(Character character);

    void unequip(Character character);
}
