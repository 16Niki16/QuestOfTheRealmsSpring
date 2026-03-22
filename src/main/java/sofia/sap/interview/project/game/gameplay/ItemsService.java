package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.events.CollectItemsEvent;
import sofia.sap.interview.project.game.events.ItemEquipEvent;
import sofia.sap.interview.project.game.events.ItemUnequipEvent;
import sofia.sap.interview.project.game.events.ItemUsedEvent;
import sofia.sap.interview.project.game.items.Consumable;
import sofia.sap.interview.project.game.items.Gear;
import sofia.sap.interview.project.game.items.ItemFactory;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.map.room.Room;

import java.util.List;
import java.util.Map;

public class ItemsService {
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
