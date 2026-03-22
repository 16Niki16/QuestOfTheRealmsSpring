package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.dto.savegame.data.MapData;
import sofia.sap.interview.project.game.gameplay.Campaign;
import sofia.sap.interview.project.game.map.Coordinates;
import sofia.sap.interview.project.game.map.Playground;

public class MapFactory {
    public static Campaign create(MapData data) {
        Coordinates playerCoordinates = data.coordinates();
        Playground playground = PlaygroundFactory.create(data.playgroundData());
        return new Campaign(playground, playerCoordinates);
    }
}
