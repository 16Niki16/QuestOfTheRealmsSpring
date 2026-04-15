package sofia.sap.interview.project.game.items;

import lombok.Getter;
import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;

import java.util.Arrays;

@Getter
public enum ItemType {
    MANA_POTION("mana potion"),
    HEALING_HERB("healing herb"),
    IRON_DAGGER("iron dagger"),
    IRON_SWORD("iron sword"),
    GOLDEN_DAGGER("golden dagger"),
    GOLDEN_SWORD("golden sword");

    private final String name;

    ItemType(String name) {
        this.name = name;
    }

    public static ItemType getByName(String itemName) {
        return Arrays.stream(values())
                .filter(type -> type.name.equalsIgnoreCase(itemName))
                .findFirst()
                .orElseThrow(() -> new ItemNotAvailableException("The provided item is not available!"));
    }

}
