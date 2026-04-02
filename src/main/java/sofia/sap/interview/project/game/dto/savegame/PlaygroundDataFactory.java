package sofia.sap.interview.project.game.dto.savegame;

import sofia.sap.interview.project.game.dto.data.PlaygroundData;
import sofia.sap.interview.project.game.dto.data.RoomData;
import sofia.sap.interview.project.game.map.Playground;
import sofia.sap.interview.project.game.map.room.Room;

public class PlaygroundDataFactory {
    public static PlaygroundData create(Playground playground) {
        Room[][] rooms = playground.rooms();
        RoomData[][] result = new RoomData[rooms.length][rooms[0].length];

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                result[i][j] = RoomDataFactory.create(rooms[i][j]);
            }
        }

        return new PlaygroundData(result);
    }
}
