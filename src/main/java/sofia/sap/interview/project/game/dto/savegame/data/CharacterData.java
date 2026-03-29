package sofia.sap.interview.project.game.dto.savegame.data;

import sofia.sap.interview.project.game.characters.ally.type.CharacterType;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.Set;

public record CharacterData(String name, CharacterType type, CharacterStatisticsData stats,
                            InventoryData inventory, EquipmentData equipment) {
}
