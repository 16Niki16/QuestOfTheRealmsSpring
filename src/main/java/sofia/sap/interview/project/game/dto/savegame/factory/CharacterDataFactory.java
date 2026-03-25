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
                transformToItemType(character.getEquippedItems().values()));
    }

    private static Set<ItemType> transformToItemType(Collection<Gear> equippedGears) {

        return equippedGears.stream()
                .map(Gear::getType)
                .collect(Collectors.toSet());
    }
}
