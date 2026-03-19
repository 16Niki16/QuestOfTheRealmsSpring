package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.dto.savegame.data.CharacterData;
import sofia.sap.interview.project.game.dto.savegame.data.MapData;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.gameplay.Gameplay;

public class GameSessionFactory {
    public static GameSession create(CharacterData characterData, MapData mapData) {
        Character character = CharacterFactory.create(characterData);
        Gameplay gameplay = MapFactory.create(mapData);
        return GameSession.load(gameplay, character);
    }
}
