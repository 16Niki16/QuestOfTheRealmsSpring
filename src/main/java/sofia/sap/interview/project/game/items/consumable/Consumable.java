package sofia.sap.interview.project.game.items.consumable;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.items.Item;

public interface Consumable extends Item {
    void consume(Character character);
}
