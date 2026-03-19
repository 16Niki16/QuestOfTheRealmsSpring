package sofia.sap.interview.project.game.items;

import sofia.sap.interview.project.game.characters.ally.Character;

public interface Consumable extends Item {
    void consume(Character character);

    String itemMessage();
}
