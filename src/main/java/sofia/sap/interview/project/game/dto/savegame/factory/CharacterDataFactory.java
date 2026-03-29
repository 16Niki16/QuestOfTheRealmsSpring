package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.dto.savegame.data.CharacterData;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.items.gear.Gear;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class CharacterDataFactory {
    public static CharacterData create(Character character) {
        return new CharacterData(character.getCharacterName(), character.getType(),
            CharacterStatisticsDataFactory.create(character.getCharacterStats()),
            InventoryDataFactory.create(character.getInventory()),
            EquipmentDataFactory.create(character.getEquipment()));
    }
}
