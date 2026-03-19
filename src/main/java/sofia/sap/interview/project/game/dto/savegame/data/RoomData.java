package sofia.sap.interview.project.game.dto.savegame.data;

import sofia.sap.interview.project.game.map.room.SpecialItem;

public record RoomData(String name, ChestData chest, EnemyData enemy, SpecialItem specialItem) {
}
