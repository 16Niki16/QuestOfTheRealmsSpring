package sofia.sap.interview.project.game.results.information;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.map.room.SpecialItem;

import static sofia.sap.interview.project.game.results.information.ViewType.*;

public record RoomInformation(ViewType viewType, boolean hasChest, EnemyType enemy, SpecialItem item)
    implements ViewInformation {
    public static RoomInformation of(Room room) {
        Enemy enemy = room.getEnemy();
        EnemyType enemyType = enemy != null ? enemy.getType() : null;
        SpecialItem specialItem = room.getSpecialItem();

        return new RoomInformation(ROOM, room.hasChest(), enemyType, specialItem);
    }
}
