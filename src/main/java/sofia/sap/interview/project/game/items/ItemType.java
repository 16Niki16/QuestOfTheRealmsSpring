package sofia.sap.interview.project.game.items;

import lombok.Getter;
import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;

import java.util.Arrays;

@Getter
public enum ItemType {
    MANA_POTION("mana potion", "mana"),
    HEALING_HERB("healing herb", "health"),
    IRON_DAGGER("iron dagger", "attack damage");

    private final String name;
    private final String source;

    ItemType(String name, String source) {
        this.name = name;
        this.source = source;
    }

    public static ItemType getByName(String itemName) {
        return Arrays.stream(values())
                .filter(type -> type.name.equalsIgnoreCase(itemName))
                .findFirst()
                .orElseThrow(() -> new ItemNotAvailableException("The provided item is not available!"));
    }

}
