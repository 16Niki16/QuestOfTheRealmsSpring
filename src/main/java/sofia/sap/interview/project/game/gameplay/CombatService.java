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
import sofia.sap.interview.project.game.items.ItemFactory;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.map.room.Room;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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
        Consumable itemToConsume = ItemFactory.createConsumable(itemType);
        character.applyPotion(itemToConsume);

        return List.of(new EventResult(ItemUsedEvent.of(itemToConsume)));
    }

    public List<CommandResult> equip(Character character, ItemType itemType) {
        Gear gearToEquip = ItemFactory.createGear(itemType);
        character.equipGear(gearToEquip);
        return List.of(new EventResult(ItemEquipEvent.equipEvent(gearToEquip)));
    }

    public List<CommandResult> unequip(Character character, ItemType itemType) {
        Gear unequippedGear = character.unequipGear(itemType);
        return List.of(new EventResult(ItemUnequipEvent.unequipEvent(unequippedGear)));
    }

    public List<CommandResult> collect(Character character, Room room) {
        Map<ItemType, Integer> items = room.collectItems();
        character.collectItems(items);
        return List.of(new EventResult(CollectItemsEvent.collectEvent(items)));
    }
}
