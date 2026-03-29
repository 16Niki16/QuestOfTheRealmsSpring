package sofia.sap.interview.project.game.inventory;

import lombok.Getter;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.items.gear.Gear;
import sofia.sap.interview.project.game.items.gear.GearType;

import java.util.EnumMap;
import java.util.Map;

@Getter
public class Equipment {
    private final Map<GearType, ItemType> items;

    public Equipment(Map<GearType, ItemType> items) {
        this.items = items;
    }

    public static Equipment newCharacterEquipment() {
        return new Equipment(new EnumMap<>(GearType.class));
    }

    public void addEquipment(Gear gear) {
        GearType gearType = gear.getGearType();
        ItemType itemType = gear.getType();

        items.put(gearType, itemType);
    }

    public void removeEquipment(Gear gear) {
        GearType gearType = gear.getGearType();
        items.remove(gearType);
    }

    public boolean alreadyEquippedType(Gear gear) {
        return items.containsKey(gear.getGearType());
    }

    public boolean compatibleItem(Gear gear) {
        ItemType equippedItemType = this.items.get(gear.getGearType());

        return equippedItemType != null && equippedItemType.equals(gear.getType());
    }
}
