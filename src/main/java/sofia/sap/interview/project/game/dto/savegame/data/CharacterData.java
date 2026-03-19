package sofia.sap.interview.project.game.dto.savegame.data;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.Set;

public record CharacterData(String name, AllyCharacterType type, CharacterStatisticsData stats,
                            InventoryData inventory, Set<ItemType> equipped) {
}
