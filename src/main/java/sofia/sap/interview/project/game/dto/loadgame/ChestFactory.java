package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.dto.savegame.data.ChestData;
import sofia.sap.interview.project.game.map.room.Chest;

public class ChestFactory {
    public static Chest create(ChestData data) {
        return new Chest(data.items());
    }
}
