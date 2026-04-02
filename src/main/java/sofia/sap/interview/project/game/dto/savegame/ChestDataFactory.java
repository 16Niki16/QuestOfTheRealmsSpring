package sofia.sap.interview.project.game.dto.savegame;

import sofia.sap.interview.project.game.dto.data.ChestData;
import sofia.sap.interview.project.game.map.room.Chest;

public class ChestDataFactory {
    public static ChestData create(Chest chest) {
        return new ChestData(chest.getContent());
    }
}
