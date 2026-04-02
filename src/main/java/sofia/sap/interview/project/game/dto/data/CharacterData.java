package sofia.sap.interview.project.game.dto.data;

import sofia.sap.interview.project.game.characters.ally.type.CharacterType;

public record CharacterData(String name, CharacterType type, CharacterStatisticsData stats,
                            InventoryData inventory, EquipmentData equipment) {
}
