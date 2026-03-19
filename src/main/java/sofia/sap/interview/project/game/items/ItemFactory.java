package sofia.sap.interview.project.game.items;

import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class ItemFactory {
    private static final Map<ItemType, Supplier<Item>> REGISTRY = new EnumMap<>(ItemType.class);

    static {
        REGISTRY.put(ItemType.HEALING_HERB, HealingHerb::new);
        REGISTRY.put(ItemType.MANA_POTION, ManaPotion::new);
        REGISTRY.put(ItemType.IRON_DAGGER, IronDagger::new);
    }

    private ItemFactory() {
    }

    public static Item create(ItemType type) {
        Supplier<Item> item = REGISTRY.get(type);

        if (item == null) {
            throw new ItemNotAvailableException("The provided item type is not available!");
        }
        return item.get();
    }

}
