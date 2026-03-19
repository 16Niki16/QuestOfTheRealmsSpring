package sofia.sap.interview.project.game.dto.newgame;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.map.room.SpecialItem;

public class RoomDTO {
    public String name;
    public EnemyType enemy;
    public ChestDTO chest;
    public SpecialItem specialItem;
}
