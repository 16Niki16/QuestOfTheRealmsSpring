package sofia.sap.interview.project.game.dto.data;

import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.items.gear.GearType;

import java.util.Map;

public record EquipmentData(Map<GearType, ItemType> equipped) {
}
