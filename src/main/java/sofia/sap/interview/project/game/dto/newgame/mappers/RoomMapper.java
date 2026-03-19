package sofia.sap.interview.project.game.dto.newgame.mappers;

import sofia.sap.interview.project.game.dto.newgame.RoomDTO;
import sofia.sap.interview.project.game.map.room.Room;

public class RoomMapper {

    public static Room map(RoomDTO content) {
        if (content == null) {
            return Room.emptyRoom();
        }

        return new Room(content.name, EnemyMapper.map(content.enemy), ChestMapper.map(content.chest),
                content.specialItem);
    }
}
