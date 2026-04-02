package sofia.sap.interview.project.game.dto.savegame;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.dto.data.CharacterData;

public class CharacterDataFactory {
    public static CharacterData create(Character character) {
        return new CharacterData(character.getCharacterName(), character.getType(),
            CharacterStatisticsDataFactory.create(character.getCharacterStats()),
            InventoryDataFactory.create(character.getInventory()),
            EquipmentDataFactory.create(character.getEquipment()));
    }
}
