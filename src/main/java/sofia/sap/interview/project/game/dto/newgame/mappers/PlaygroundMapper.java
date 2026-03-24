package sofia.sap.interview.project.game.dto.newgame.mappers;

import sofia.sap.interview.project.game.exceptions.NewGameMapException;
import sofia.sap.interview.project.game.map.Playground;
import sofia.sap.interview.project.game.dto.newgame.PlaygroundDTO;
import sofia.sap.interview.project.game.map.room.Room;

public class PlaygroundMapper {
    public static Playground map(PlaygroundDTO dto) {
        if (dto == null) {
            throw new NewGameMapException("Problem with map playground creation!");
        }

        Room[][] rooms = new Room[dto.rooms.length][dto.rooms[0].length];

        for (int y = 0; y < dto.rooms.length; y++) {
            for (int x = 0; x < dto.rooms[y].length; x++) {
                rooms[y][x] = RoomMapper.map(dto.rooms[y][x]);
            }
        }

        return new Playground(rooms);
    }
}
