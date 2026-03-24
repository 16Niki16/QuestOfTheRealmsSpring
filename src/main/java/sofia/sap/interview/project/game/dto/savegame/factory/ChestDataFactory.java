package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.dto.savegame.data.ChestData;
import sofia.sap.interview.project.game.map.room.Chest;

public class ChestDataFactory {
    public static ChestData create(Chest chest) {
        return new ChestData(chest.content());
    }
}
