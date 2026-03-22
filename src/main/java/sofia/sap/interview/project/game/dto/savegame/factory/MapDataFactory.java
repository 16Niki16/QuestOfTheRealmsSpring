package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.dto.savegame.data.MapData;
import sofia.sap.interview.project.game.gameplay.Campaign;

public class MapDataFactory {
    public static MapData create(Campaign campaign) {
        return new MapData(PlaygroundDataFactory.create(campaign.getPlayground()), campaign.getPlayerCoordinates());
    }
}
