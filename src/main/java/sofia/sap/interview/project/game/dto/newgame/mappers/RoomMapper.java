package sofia.sap.interview.project.game.dto.newgame.mappers;

import sofia.sap.interview.project.game.dto.newgame.RoomDTO;
import sofia.sap.interview.project.game.exceptions.NewGameMapException;
import sofia.sap.interview.project.game.map.room.Room;

public class RoomMapper {

    public static Room map(RoomDTO content) {
        if (content == null) {
            throw new NewGameMapException("There is a mistake in room creation!");
        }

        return new Room(content.name, EnemyMapper.map(content.enemy), ChestMapper.map(content.chest),
                content.specialItem);
    }
}
