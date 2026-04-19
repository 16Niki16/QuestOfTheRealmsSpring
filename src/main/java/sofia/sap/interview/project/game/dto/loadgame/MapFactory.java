package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.dto.data.MapData;
import sofia.sap.interview.project.game.gameplay.Campaign;
import sofia.sap.interview.project.game.map.Coordinates;
import sofia.sap.interview.project.game.map.Playground;

import static sofia.sap.interview.project.game.dto.loadgame.PlaygroundFactory.create;

public class MapFactory {
    public static Campaign createCampaign(MapData data) {
        Coordinates playerCoordinates = data.coordinates();
        Playground playground = create(data.playgroundData());
        return new Campaign(playground, playerCoordinates);
    }
}
