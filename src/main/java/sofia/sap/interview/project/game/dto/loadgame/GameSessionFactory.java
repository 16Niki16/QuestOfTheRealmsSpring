package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.dto.data.CharacterData;
import sofia.sap.interview.project.game.dto.data.MapData;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.gameplay.Campaign;

public class GameSessionFactory {
    public static GameSession createGameSession(CharacterData characterData, MapData mapData) {
        Character character = CharacterFactory.create(characterData);
        Campaign campaign = MapFactory.createCampaign(mapData);

        return new GameSession(campaign, character);
    }
}
