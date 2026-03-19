package sofia.sap.interview.project.game.dto.savegame.data;

import sofia.sap.interview.project.game.items.ItemType;

import java.util.Map;

public record InventoryData(Map<ItemType, Integer> items) {
}
