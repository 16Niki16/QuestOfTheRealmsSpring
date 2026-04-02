package sofia.sap.interview.project.game.dto.savegame;

import sofia.sap.interview.project.game.dto.data.MapData;
import sofia.sap.interview.project.game.gameplay.Campaign;

public class MapDataFactory {
    public static MapData create(Campaign campaign) {
        return new MapData(PlaygroundDataFactory.create(campaign.getPlayground()), campaign.getPlayerCoordinates());
    }
}
