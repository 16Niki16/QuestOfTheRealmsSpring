package sofia.sap.interview.project.game.dto.data;

import sofia.sap.interview.project.game.items.ItemType;

import java.util.Map;

public record ChestData(Map<ItemType, Integer> items) {
}
