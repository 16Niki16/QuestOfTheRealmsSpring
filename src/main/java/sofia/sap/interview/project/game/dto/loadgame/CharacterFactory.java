package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.statistics.CharacterStatistics;
import sofia.sap.interview.project.game.dto.savegame.data.CharacterData;
import sofia.sap.interview.project.game.inventory.Inventory;
import sofia.sap.interview.project.game.items.Gear;
import sofia.sap.interview.project.game.items.ItemFactory;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CharacterFactory {
    public static Character create(CharacterData data) {
        CharacterStatistics stats = CharacterStatisticsFactory.create(data.stats());
        Inventory inventory = InventoryFactory.create(data.inventory());

        return new Character(data.name(), data.type(), stats, inventory, equippedItems(data.equipped()));
    }
    private static Map<ItemType, Gear> equippedItems(Set<ItemType> equippedItemsData){
        return equippedItemsData.stream()
            .collect(Collectors.toMap(itemType -> itemType,
               ItemFactory::createGear,
                (a,b) -> b,
                () -> new EnumMap<>(ItemType.class)));
    }
}
