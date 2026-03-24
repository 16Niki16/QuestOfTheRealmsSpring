package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.statistics.CharacterStatistics;
import sofia.sap.interview.project.game.dto.savegame.data.CharacterData;
import sofia.sap.interview.project.game.inventory.Inventory;
import sofia.sap.interview.project.game.items.gear.Gear;
import sofia.sap.interview.project.game.items.ItemRegistry;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.items.gear.GearType;

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

    private static Map<GearType, Gear> equippedItems(Set<ItemType> equippedItemsData) {
        Set<Gear> equippedGears = equippedItemsData.stream()
            .map(ItemRegistry::createGear)
            .collect(Collectors.toSet());

        return equippedGears.stream()
            .collect(Collectors.toMap(
                Gear::getGearType,
                gear -> gear,
                (a, b) -> b,
                () -> new EnumMap<>(GearType.class)));
    }
}
