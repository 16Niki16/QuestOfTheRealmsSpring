package sofia.sap.interview.project.game.items;

import sofia.sap.interview.project.game.characters.ally.Character;

public interface Gear extends Item {
    void equip(Character character);

    void unequip(Character character);
}
