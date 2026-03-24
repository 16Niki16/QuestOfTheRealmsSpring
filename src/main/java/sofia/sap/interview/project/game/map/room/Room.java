package sofia.sap.interview.project.game.map.room;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.exceptions.ChestNotAvailableException;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.Map;

@Getter
public class Room {
    private static final String SAFE_PATH = "Safe path";
    private final String name;
    private Enemy enemy;
    private Chest chest;
    private SpecialItem specialItem;

    public Room(String name, Enemy enemy, Chest chest, SpecialItem specialItem) {
        this.enemy = enemy;
        this.chest = chest;
        this.specialItem = specialItem;
        this.name = name;
    }

    public Map<ItemType, Integer> collectItems() {
        if (this.chest == null) {
            throw new ChestNotAvailableException("There is not a chest in this room!");
        }

        Map<ItemType, Integer> items = this.chest.collectItems();
        this.chest = null;

        return items;
    }

    public void collectSpecialItem() {
        this.specialItem = null;
    }

    public void killEnemy() {
        this.enemy = null;
    }

    public boolean hasChest() {
        return this.chest != null;
    }
}
