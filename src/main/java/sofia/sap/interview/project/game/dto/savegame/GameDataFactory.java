package sofia.sap.interview.project.game.dto.savegame;

import sofia.sap.interview.project.game.dto.data.GameData;
import sofia.sap.interview.project.game.gameplay.GameSession;

public class GameDataFactory {
    public static GameData save(GameSession session) {
        return new GameData(session.sessionName(), CharacterDataFactory.create(session.character()),
                MapDataFactory.create(session.campaign()), QuestsDataFactory.create(session.log()));
    }
}
