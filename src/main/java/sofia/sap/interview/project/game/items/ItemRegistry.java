package sofia.sap.interview.project.game.items;

import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class ItemRegistry {

    private static final Map<ItemType, Supplier<Consumable>> CONSUMABLES = new EnumMap<>(ItemType.class);
    private static final Map<ItemType, Supplier<Gear>> GEAR = new EnumMap<>(ItemType.class);

    static {
        CONSUMABLES.put(ItemType.HEALING_HERB, HealingHerb::new);
        CONSUMABLES.put(ItemType.MANA_POTION, ManaPotion::new);

        GEAR.put(ItemType.IRON_DAGGER, IronDagger::new);
    }

    public static Item create(ItemType itemType) {
        if (CONSUMABLES.containsKey(itemType)) {
            return createConsumable(itemType);
        }

        return createGear(itemType);
    }

    public static Consumable createConsumable(ItemType itemType) {
        Supplier<Consumable> supplier = CONSUMABLES.get(itemType);
        if (supplier == null) {
            throw new ItemNotAvailableException("The provided item is not consumable!");
        }

        return supplier.get();
    }

    public static Gear createGear(ItemType itemType) {
        Supplier<Gear> supplier = GEAR.get(itemType);
        if (supplier == null) {
            throw new ItemNotAvailableException("The provided item is not gear!");
        }

        return supplier.get();
    }

    private ItemRegistry() {
    }
}
