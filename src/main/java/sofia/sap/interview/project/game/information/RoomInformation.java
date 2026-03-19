package sofia.sap.interview.project.game.information;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.map.room.SpecialItem;

public record RoomInformation(boolean hasChest, EnemyType enemy, SpecialItem item) implements ViewInformation {
}
