package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.dto.savegame.data.GameData;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.quests.QuestLog;

public record LoadedInformation(GameSession session, QuestLog log) {
    public static LoadedInformation load(GameData data) {
        QuestLog log = QuestLogFactory.create(data.quests());
        GameSession session = GameSessionFactory.create(data.character(), data.map());
        return new LoadedInformation(session, log);
    }
}
