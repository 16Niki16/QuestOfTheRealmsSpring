package sofia.sap.interview.project.game.information;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.map.room.SpecialItem;

public record RoomInformation(ViewType viewType, boolean hasChest, EnemyType enemy, SpecialItem item)
    implements ViewInformation {
    public static RoomInformation of(boolean hasChest, EnemyType enemy, SpecialItem item) {
        return new RoomInformation(ViewType.ROOM, hasChest, enemy, item);
    }
}
