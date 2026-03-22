package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.dto.savegame.data.CharacterData;
import sofia.sap.interview.project.game.items.Gear;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.Map;
import java.util.Set;

public class CharacterDataFactory {
    public static CharacterData create(Character character) {
        return new CharacterData(character.getCharacterName(), character.getType(),
            CharacterStatisticsDataFactory.create(character.getCharacterStats()),
            InventoryDataFactory.create(character.getInventory()), character.getEquippedItems().keySet());
    }
}
