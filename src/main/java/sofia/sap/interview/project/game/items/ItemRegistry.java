package sofia.sap.interview.project.game.items;

import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;
import sofia.sap.interview.project.game.items.consumable.Consumable;
import sofia.sap.interview.project.game.items.consumable.HealingHerb;
import sofia.sap.interview.project.game.items.consumable.ManaPotion;
import sofia.sap.interview.project.game.items.gear.Gear;
import sofia.sap.interview.project.game.items.gear.GoldenDagger;
import sofia.sap.interview.project.game.items.gear.GoldenSword;
import sofia.sap.interview.project.game.items.gear.IronDagger;
import sofia.sap.interview.project.game.items.gear.IronSword;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import static sofia.sap.interview.project.game.items.ItemType.GOLDEN_DAGGER;
import static sofia.sap.interview.project.game.items.ItemType.GOLDEN_SWORD;
import static sofia.sap.interview.project.game.items.ItemType.HEALING_HERB;
import static sofia.sap.interview.project.game.items.ItemType.IRON_DAGGER;
import static sofia.sap.interview.project.game.items.ItemType.IRON_SWORD;
import static sofia.sap.interview.project.game.items.ItemType.MANA_POTION;

public class ItemRegistry {

    private static final Map<ItemType, Supplier<Consumable>> CONSUMABLES = new EnumMap<>(ItemType.class);
    private static final Map<ItemType, Supplier<Gear>> GEAR = new EnumMap<>(ItemType.class);

    static {
        CONSUMABLES.put(HEALING_HERB, HealingHerb::new);
        CONSUMABLES.put(MANA_POTION, ManaPotion::new);

        GEAR.put(IRON_DAGGER, IronDagger::new);
        GEAR.put(IRON_SWORD, IronSword::new);
        GEAR.put(GOLDEN_DAGGER, GoldenDagger::new);
        GEAR.put(GOLDEN_SWORD, GoldenSword::new);
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
