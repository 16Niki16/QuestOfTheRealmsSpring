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
    public List<CommandResult> attack(Character character, Enemy enemy, Room currentRoom) {
        List<CommandResult> results = new ArrayList<>();
        int damageDealt = character.attackEnemy();
        boolean isEnemyDead = enemy.defendAgainstAllyCharacter(damageDealt);
        results.add(new EventResult(AttackEvent.of(character, damageDealt, enemy)));
        if (isEnemyDead) {
            currentRoom.killEnemy();
            results.add(new EventResult(KillEnemyEvent.of(character, enemy)));
        }
        return results;
    }

    public List<CommandResult> defend(GameSession session, Enemy enemy) {
        Character character = session.character();
        List<CommandResult> results = new ArrayList<>();
        int damage = enemy.attackDamage();
        boolean dead = character.defendAgainstEnemy(damage);
        results.add(new EventResult(DefendEvent.of(character, damage, enemy)));

        if (dead) {
            results.add(new EventResult(CharacterDiedEvent.of(character, enemy)));
        }
        return results;
    }

    public List<CommandResult> useItem(Character character, ItemType itemType) {
        Item item = character.getInventory().getItem(itemType);

        if (!(item instanceof Consumable consumable)) {
            throw new ItemNotAvailableException("The provided item is not consumable!");
        }
        character.applyPotion(consumable);
        return List.of(new EventResult(ItemUsedEvent.of(consumable)));
    }

    public List<CommandResult> equip(Character character, ItemType itemType) {
        Item item = character.getInventory().getItem(itemType);

        if (!(item instanceof Gear gear)) {
            throw new ItemNotAvailableException("The provided item is not gear!");
        }
        character.equipGear(gear);

        return List.of(new EventResult(ItemEquipEvent.equipEvent(item)));
    }

    public List<CommandResult> unequip(Character character, ItemType itemType) {
        Item item = character.getEquippedItem(itemType);

        if (!(item instanceof Gear gear)) {
            throw new ItemNotAvailableException("The provided item is not gear!");
        }
        character.unequipGear(gear);

        return List.of(new EventResult(ItemUnequipEvent.unequipEvent(item)));
    }

    public List<CommandResult> collect(Character character, Room room) {
        Collection<Item> items = room.collectItems();
        character.collectItems(items);
        return List.of(new EventResult(CollectItemsEvent.collectEvent(items)));
    }
}
