package sofia.sap.interview.project.game.characters.ally;

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
import java.util.HashSet;
import java.util.Set;

public class Character {
    private final String characterName;
    private final AllyCharacterType type;
    private final CharacterStatistics characterStats;
    private final Inventory inventory;
    private final Set<ItemType> equippedItems;

    public Character(String characterName, AllyCharacterType type) {
        this.characterName = characterName;
        this.type = type;
        this.characterStats = new CharacterStatistics(type);
        this.inventory = new Inventory();
        this.equippedItems = new HashSet<>();
    }

    public Character(String characterName, AllyCharacterType type, CharacterStatistics stats,
                     Inventory inventory, Set<ItemType> equipped) {
        this.characterName = characterName;
        this.type = type;
        this.characterStats = stats;
        this.inventory = inventory;
        this.equippedItems = equipped;
    }

    public String getCharacterName() {
        return this.characterName;
    }

    public AllyCharacterType getCharacterType() {
        return this.type;
    }

    public CharacterStatistics getCharacterStats() {
        return this.characterStats;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public Set<ItemType> getEquippedItems() {
        return this.equippedItems;
    }

    public Item getEquippedItem(ItemType itemType) {
        if (this.equippedItems.contains(itemType)) {
            return ItemFactory.create(itemType);
        }
        throw new EquipmentNotEquippedException("The provided equipment is not equipped!");
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
        if (this.equippedItems.contains(itemToEquip.getType())) {
            throw new ItemTypeAlreadyEquippedException("This kind of item is already equipped by the ally character!");
        }

        this.equippedItems.add(itemToEquip.getType());
        this.inventory.removeItem(itemToEquip);
        itemToEquip.equip(this);
    }

    public void unequipGear(Gear gear) {
        if (!this.equippedItems.contains(gear.getType())) {
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

    public boolean isCharacterDead() {
        return this.characterStats.isDead();
    }

    public void regen(int amount) {
        this.characterStats.regenerate(amount);
    }

}
