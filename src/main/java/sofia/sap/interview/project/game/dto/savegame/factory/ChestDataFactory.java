package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.dto.savegame.data.ChestData;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.map.room.Chest;

import java.util.Map;
import java.util.stream.Collectors;

public class ChestDataFactory {
    public static ChestData create(Chest chest) {
        return new ChestData(chest.getContent());
    }
}
