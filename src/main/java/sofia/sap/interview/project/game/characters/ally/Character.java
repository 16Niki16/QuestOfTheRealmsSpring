package sofia.sap.interview.project.game.characters.ally;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.characters.statistics.CharacterStatistics;
import sofia.sap.interview.project.game.dto.savegame.data.CharacterData;
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
            throw new ItemTypeAlreadyEquippedException("Item of this type is already equipped by the character!");
        }

        this.inventory.removeItem(itemToEquip);
        this.equippedItems.put(itemToEquip.getType(), itemToEquip);
        itemToEquip.equip(this);
    }

    public Gear unequipGear(ItemType gearType) {
        if (!this.equippedItems.containsKey(gearType)) {
            throw new EquipmentNotEquippedException("The provided item is not equipped!");
        }
        Gear gearToUnequip = this.equippedItems.get(gearType);
        this.equippedItems.remove(gearType);
        this.inventory.addItem(gearType);
        gearToUnequip.unequip(this);
        return gearToUnequip;
    }

    public void collectItems(Map<ItemType, Integer> items) {
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
