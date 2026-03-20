package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.events.AttackEvent;
import sofia.sap.interview.project.game.events.CharacterDiedEvent;
import sofia.sap.interview.project.game.events.CollectItemsEvent;
import sofia.sap.interview.project.game.events.DefendEvent;
import sofia.sap.interview.project.game.events.ItemEquipEvent;
import sofia.sap.interview.project.game.events.ItemUnequipEvent;
import sofia.sap.interview.project.game.events.ItemUsedEvent;
import sofia.sap.interview.project.game.events.KillEnemyEvent;
import sofia.sap.interview.project.game.events.NotEnoughManaEvent;
import sofia.sap.interview.project.game.exceptions.ItemNotAvailableException;
import sofia.sap.interview.project.game.items.Consumable;
import sofia.sap.interview.project.game.items.Gear;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.map.room.Room;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CombatService {
    public List<CommandResult> attack(Character character, Enemy currentEnemy, Room currentRoom) {
        List<CommandResult> attackResults = new ArrayList<>();
        int damageDealt = character.attackEnemy();
        if (damageDealt == 0) {
            attackResults.add(new EventResult(NotEnoughManaEvent.of(character, currentEnemy)));
            return attackResults;
        }
        boolean isEnemyDead = currentEnemy.defendAgainstAllyCharacter(damageDealt);
        attackResults.add(new EventResult(AttackEvent.of(character, damageDealt, currentEnemy)));

        if (isEnemyDead) {
            currentRoom.killEnemy();
            attackResults.add(new EventResult(KillEnemyEvent.of(character, currentEnemy)));
        }
        return attackResults;
    }

    public List<CommandResult> defend(Character character, Enemy currentEnemy) {
        List<CommandResult> enemyAttackResults = new ArrayList<>();
        int damageDealt = currentEnemy.attackDamage();
        boolean isCharacterDead = character.defendAgainstEnemy(damageDealt);
        enemyAttackResults.add(new EventResult(DefendEvent.of(character, damageDealt, currentEnemy)));

        if (isCharacterDead) {
            enemyAttackResults.add(new EventResult(CharacterDiedEvent.of(character, currentEnemy)));
        }
        return enemyAttackResults;
    }

    public List<CommandResult> useItem(Character character, ItemType itemType) {
        Item itemToConsume = character.getInventory().getItem(itemType);

        if (itemToConsume instanceof Consumable consumable) {
            character.applyPotion(consumable);
            return List.of(new EventResult(ItemUsedEvent.of(consumable)));
        }
        throw new ItemNotAvailableException("The provided item is not correct!");

    }

    public List<CommandResult> equip(Character character, ItemType itemType) {
        Item item = character.getInventory().getItem(itemType);

        if (item instanceof Gear gear) {
            character.equipGear(gear);
            return List.of(new EventResult(ItemEquipEvent.equipEvent(item)));
        }
        throw new ItemNotAvailableException("The provided item is not gear!");

    }

    public List<CommandResult> unequip(Character character, ItemType itemType) {
        Item item = character.getEquippedItem(itemType);

        if (item instanceof Gear gear) {
            character.unequipGear(gear);
            return List.of(new EventResult(ItemUnequipEvent.unequipEvent(item)));
        }
        throw new ItemNotAvailableException("The provided item is not gear!");

    }

    public List<CommandResult> collect(Character character, Room room) {
        Collection<Item> items = room.collectItems();
        character.collectItems(items);
        return List.of(new EventResult(CollectItemsEvent.collectEvent(items)));
    }
}
