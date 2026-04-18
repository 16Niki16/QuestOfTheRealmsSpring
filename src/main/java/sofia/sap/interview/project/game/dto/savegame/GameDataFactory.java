package sofia.sap.interview.project.game.dto.savegame;

import sofia.sap.interview.project.game.dto.data.GameData;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.quests.QuestLog;

public class GameDataFactory {
    public static GameData save(GameSession session, QuestLog log) {
        return new GameData(CharacterDataFactory.create(session.character()),
            MapDataFactory.create(session.campaign()), QuestsDataFactory.create(log));
    }
}
