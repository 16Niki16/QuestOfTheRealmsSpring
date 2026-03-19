package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.dto.savegame.data.RoomData;
import sofia.sap.interview.project.game.map.room.Chest;
import sofia.sap.interview.project.game.map.room.Room;

public class RoomFactory {
    public static Room create(RoomData data) {
        Enemy enemy = null;
        Chest chest = null;

        if (data.enemy() != null) {
            enemy = EnemyFactory.create(data.enemy());
        }
        if (data.chest() != null) {
            chest = ChestFactory.create(data.chest());
        }
        return new Room(data.name(), enemy, chest, data.specialItem());
    }
}
