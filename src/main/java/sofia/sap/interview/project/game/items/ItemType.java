package sofia.sap.interview.project.game.items;

import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;

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
        for (ItemType type : values()) {
            if (type.name.equals(itemName)) {
                return type;
            }
        }
        throw new ItemNotAvailableException("The provided item is not available!");
    }

    public String getName() {
        return this.name;
    }

    public String getSource() {
        return this.source;
    }
}
