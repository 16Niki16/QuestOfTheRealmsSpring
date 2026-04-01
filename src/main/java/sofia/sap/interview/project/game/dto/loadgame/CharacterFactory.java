package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.statistics.CharacterStatistics;
import sofia.sap.interview.project.game.dto.savegame.data.CharacterData;
import sofia.sap.interview.project.game.inventory.Equipment;
import sofia.sap.interview.project.game.inventory.Inventory;

public class CharacterFactory {
    public static Character create(CharacterData data) {
        CharacterStatistics stats = CharacterStatisticsFactory.create(data.stats());
        Inventory inventory = InventoryFactory.create(data.inventory());
        Equipment equipment = EquipmentFactory.create(data.equipment());

        return new Character(data.name(), data.type(), stats, inventory, equipment);
    }
}
