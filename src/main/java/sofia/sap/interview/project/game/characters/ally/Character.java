package sofia.sap.interview.project.game.characters.ally;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sofia.sap.interview.project.game.characters.ally.type.CharacterType;
import sofia.sap.interview.project.game.characters.statistics.CharacterStatistics;
import sofia.sap.interview.project.game.exceptions.EquipmentNotEquippedException;
import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;
import sofia.sap.interview.project.game.exceptions.ItemTypeAlreadyEquippedException;
import sofia.sap.interview.project.game.inventory.Equipment;
import sofia.sap.interview.project.game.inventory.Inventory;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.items.consumable.Consumable;
import sofia.sap.interview.project.game.items.gear.Gear;

import java.util.Map;

import static sofia.sap.interview.project.game.inventory.Equipment.newCharacterEquipment;
import static sofia.sap.interview.project.game.inventory.Inventory.newCharacterInventory;

@Getter
@AllArgsConstructor
public class Character {
    private final String characterName;
    private final CharacterType type;
    private final CharacterStatistics characterStats;
    private final Inventory inventory;
    private final Equipment equipment;

    public static Character createNewCharacter(String characterName, CharacterType type) {
        CharacterStatistics characterStats = new CharacterStatistics(type.getHealth(), type.getAttackRange(),
            type.getMana(), type.getManaCost());

        return new Character(characterName, type, characterStats,
            newCharacterInventory(),
            newCharacterEquipment());
    }

    public int attackEnemy() {
        return this.characterStats.attack();
    }

    public void defendAgainstEnemy(int enemyDamage) {
        this.characterStats.decreaseHealth(enemyDamage);
    }

    public void applyPotion(Consumable potionToConsume) {
        if (!this.inventory.checkItemAvailable(potionToConsume)) {
            throw new ItemNotAvailableException("There is not an item of this type in inventory!");
        }

        this.inventory.removeItem(potionToConsume);
        potionToConsume.consume(this);
    }

    public void equipGear(Gear itemToEquip) {
        if (equipment.alreadyEquippedType(itemToEquip)) {
            throw new ItemTypeAlreadyEquippedException("Item of this type is already equipped by the character!");
        } else if (!inventory.checkItemAvailable(itemToEquip)) {
            throw new ItemNotAvailableException("The provided item is not part of the inventory!");
        }

        this.inventory.removeItem(itemToEquip);
        this.equipment.addEquipment(itemToEquip);
        itemToEquip.equip(this);
    }

    public void unequipGear(Gear itemToUnequip) {
        if (!equipment.compatibleItem(itemToUnequip)) {
            throw new EquipmentNotEquippedException("The provided item is not equipped!");
        }

        this.equipment.removeEquipment(itemToUnequip);
        this.inventory.addItem(itemToUnequip);
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
