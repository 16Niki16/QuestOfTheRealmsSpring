package sofia.sap.interview.project.game.characters.ally;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.characters.statistics.CharacterStatistics;
import sofia.sap.interview.project.game.exceptions.EquipmentNotEquippedException;
import sofia.sap.interview.project.game.exceptions.ItemTypeAlreadyEquippedException;
import sofia.sap.interview.project.game.inventory.Inventory;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.items.consumable.Consumable;
import sofia.sap.interview.project.game.items.gear.Gear;
import sofia.sap.interview.project.game.items.gear.GearType;

import java.util.EnumMap;
import java.util.Map;

@Getter
public class Character {
    private final String characterName;
    private final AllyCharacterType type;
    private final CharacterStatistics characterStats;
    private final Inventory inventory;
    private final Map<GearType, Gear> equippedItems;

    public Character(String characterName, AllyCharacterType type, CharacterStatistics stats,
                     Inventory inventory, Map<GearType, Gear> equipped) {
        this.characterName = characterName;
        this.type = type;
        this.characterStats = stats;
        this.inventory = inventory;
        this.equippedItems = equipped;
    }

    public static Character createNewCharacter(String characterName, AllyCharacterType type) {
        return new Character(characterName, type, CharacterStatistics.createNewCharacter(type), new Inventory(),
                new EnumMap<>(GearType.class));
    }

    public int attackEnemy() {
        return this.characterStats.attack();
    }

    public void defendAgainstEnemy(int enemyDamage) {
        this.characterStats.decreaseHealth(enemyDamage);
    }

    public void applyPotion(Consumable potionToConsume) {
        this.inventory.removeItem(potionToConsume);
        potionToConsume.consume(this);
    }

    public void equipGear(Gear itemToEquip) {
        GearType gearType = itemToEquip.getGearType();

        if (this.equippedItems.containsKey(gearType)) {
            throw new ItemTypeAlreadyEquippedException("Item of this type is already equipped by the character!");
        }

        this.inventory.removeItem(itemToEquip);
        this.equippedItems.put(itemToEquip.getGearType(), itemToEquip);
        itemToEquip.equip(this);
    }

    public void unequipGear(Gear itemToUnequip) {
        GearType gearType = itemToUnequip.getGearType();

        if (!this.equippedItems.containsKey(gearType) ||
                !this.equippedItems.get(gearType).getType().equals(itemToUnequip.getType())) {
            throw new EquipmentNotEquippedException("The provided item is not equipped!");
        }

        this.equippedItems.remove(gearType);
        this.inventory.addItem(itemToUnequip.getType());
        itemToUnequip.unequip(this);
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

}
