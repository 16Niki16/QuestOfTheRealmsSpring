package sofia.sap.interview.project.game.characters.ally;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.characters.statistics.CharacterStatistics;
import sofia.sap.interview.project.game.exceptions.EquipmentNotEquippedException;
import sofia.sap.interview.project.game.exceptions.ItemTypeAlreadyEquippedException;
import sofia.sap.interview.project.game.inventory.Inventory;
import sofia.sap.interview.project.game.items.Consumable;
import sofia.sap.interview.project.game.items.Gear;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemFactory;
import sofia.sap.interview.project.game.items.ItemType;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
public class Character {
    private final String characterName;
    private final AllyCharacterType type;
    private final CharacterStatistics characterStats;
    private final Inventory inventory;
    private final Map<ItemType, Gear> equippedItems;

    public Character(String characterName, AllyCharacterType type) {
        this.characterName = characterName;
        this.type = type;
        this.characterStats = new CharacterStatistics(type);
        this.inventory = new Inventory();
        this.equippedItems = new EnumMap<>(ItemType.class);
    }

    public Character(String characterName, AllyCharacterType type, CharacterStatistics stats,
                     Inventory inventory, Map<ItemType, Gear> equipped) {
        this.characterName = characterName;
        this.type = type;
        this.characterStats = stats;
        this.inventory = inventory;
        this.equippedItems = equipped;
    }

    public Item getEquippedItem(ItemType itemType) {
        Item equippedItem = this.equippedItems.get(itemType);

        if (equippedItem == null) {
            throw new EquipmentNotEquippedException("The provided equipment is not equipped!");

        }
        return equippedItem;
    }

    public int attackEnemy() {
        return this.characterStats.attack();
    }

    public boolean defendAgainstEnemy(int enemyDamage) {
        return this.characterStats.decreaseHealth(enemyDamage);
    }

    public void applyPotion(Consumable potionToConsume) {
        this.inventory.removeItem(potionToConsume);
        potionToConsume.consume(this);
    }

    public void equipGear(Gear itemToEquip) {
        if (this.equippedItems.containsKey(itemToEquip.getType())) {
            throw new ItemTypeAlreadyEquippedException("This kind of item is already equipped by the ally character!");
        }

        this.equippedItems.put(itemToEquip.getType(), itemToEquip);
        this.inventory.removeItem(itemToEquip);
        itemToEquip.equip(this);
    }

    public void unequipGear(Gear gear) {
        if (this.equippedItems.containsKey(gear.getType())) {
            throw new EquipmentNotEquippedException("The provided item is not equipped!");
        }

        this.equippedItems.remove(gear.getType());
        this.inventory.addItem(gear);
        gear.unequip(this);
    }

    public void collectItems(Collection<Item> items) {
        this.inventory.addAllItems(items);
    }

    public void heal(int amount) {
        this.characterStats.increaseHealth(amount);
    }

    public void restoreMana(int amount) {
        this.characterStats.increaseMana(amount);
    }

    public void increaseAttackDamage(int amount) {
        this.characterStats.increaseAttackRange(amount);
    }

    public void decreaseAttackDamage(int amount) {
        this.characterStats.decreaseAttackRange(amount);
    }

    public void regen(int amount) {
        this.characterStats.regenerate(amount);
    }

}
