package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.dto.savegame.data.GameData;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.quests.QuestLog;

public class GameDataFactory {
    public static GameData save(GameSession session, QuestLog log) {
        return new GameData(CharacterDataFactory.create(session.character()),
            MapDataFactory.create(session.gameplay()), QuestsDataFactory.create(log));
    }
}
