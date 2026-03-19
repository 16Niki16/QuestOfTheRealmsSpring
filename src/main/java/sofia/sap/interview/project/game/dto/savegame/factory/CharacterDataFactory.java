package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.dto.savegame.data.CharacterData;

public class CharacterDataFactory {
    public static CharacterData create(Character character) {
        return new CharacterData(character.getCharacterName(), character.getCharacterType(),
                CharacterStatisticsDataFactory.create(character.getCharacterStats()),
                InventoryDataFactory.create(character.getInventory()), character.getEquippedItems());
    }

}
