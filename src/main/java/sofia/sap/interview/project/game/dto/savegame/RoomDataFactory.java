package sofia.sap.interview.project.game.dto.savegame;

import sofia.sap.interview.project.game.dto.data.ChestData;
import sofia.sap.interview.project.game.dto.data.EnemyData;
import sofia.sap.interview.project.game.dto.data.RoomData;
import sofia.sap.interview.project.game.map.room.Room;

public class RoomDataFactory {
    public static RoomData create(Room room) {

        ChestData chestData = null;
        EnemyData enemyData = null;

        if (room.getChest() != null) {
            chestData = ChestDataFactory.create(room.getChest());
        }

        if (room.getEnemy() != null) {
            enemyData = EnemyDataFactory.create(room.getEnemy());
        }

        return new RoomData(room.getName(), chestData, enemyData, room.getSpecialItem());
    }
}
