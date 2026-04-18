package sofia.sap.interview.project.game.gameplay;

import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.items.consumable.Consumable;
import sofia.sap.interview.project.game.items.gear.Gear;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.events.CollectItemsEvent;
import sofia.sap.interview.project.game.results.events.ItemEquipEvent;
import sofia.sap.interview.project.game.results.events.ItemUnequipEvent;
import sofia.sap.interview.project.game.results.events.ItemUsedEvent;

import java.util.List;
import java.util.Map;

import static sofia.sap.interview.project.game.items.ItemRegistry.createConsumable;
import static sofia.sap.interview.project.game.items.ItemRegistry.createGear;

@Service
public class ItemsService {
    public List<CommandResult> useItem(Character character, ItemType itemType) {
        Consumable itemToConsume = createConsumable(itemType);
        character.applyPotion(itemToConsume);

        return List.of(ItemUsedEvent.of(itemToConsume));
    }

    public List<CommandResult> equip(Character character, ItemType itemType) {
        Gear gearToEquip = createGear(itemType);
        character.equipGear(gearToEquip);

        return List.of(ItemEquipEvent.equipEvent(gearToEquip));
    }

    public List<CommandResult> unequip(Character character, ItemType itemType) {
        Gear gearToUnequip = createGear(itemType);
        character.unequipGear(gearToUnequip);

        return List.of(ItemUnequipEvent.unequipEvent(gearToUnequip));
    }

    public List<CommandResult> collect(Character character, Room room) {
        Map<ItemType, Integer> items = room.collectItems();
        character.collectItems(items);

        return List.of(CollectItemsEvent.collectEvent(items));
    }
}
