package sofia.sap.interview.project.game.map.room;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.EnemyState;
import sofia.sap.interview.project.game.exceptions.ChestNotAvailableException;
import sofia.sap.interview.project.game.items.Item;

import java.util.Collection;

public class Room {
    private static final String SAFE_PATH = "Safe path";
    private final String name;
    private Enemy enemy;
    private final EnemyState state;
    private Chest chest;
    private SpecialItem specialItem;

    public Room(String name, Enemy enemy, Chest chest, SpecialItem specialItem) {
        this.enemy = enemy;
        this.chest = chest;
        this.specialItem = specialItem;
        this.name = name;
        this.state = enemy == null ? null : new EnemyState();
    }

    public EnemyState getState() {
        return this.state;
    }

    public String getName() {
        return this.name;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }

    public Chest getChest() {
        return this.chest;
    }

    public SpecialItem getSpecialItem() {
        return this.specialItem;
    }

    public static Room emptyRoom() {
        return new Room(SAFE_PATH, null, null, null);
    }

    public Collection<Item> collectItems() {
        if (this.chest == null) {
            throw new ChestNotAvailableException("There is not a chest in this room!");
        }

        Collection<Item> items = this.chest.collectItems();
        this.chest = null;
        return items;
    }

    public void collectSpecialItem() {
        this.specialItem = null;
    }

    public boolean hasEnemy() {
        return !(this.enemy == null);
    }

    public void killEnemy() {
        this.enemy = null;
    }

    public boolean hasChest() {
        return this.chest != null;
    }
}
