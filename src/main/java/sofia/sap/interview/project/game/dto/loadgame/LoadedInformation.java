package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.dto.data.GameData;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.quests.QuestLog;

import static sofia.sap.interview.project.game.dto.loadgame.GameSessionFactory.createGameSession;
import static sofia.sap.interview.project.game.dto.loadgame.QuestLogFactory.createQuestLog;

public record LoadedInformation(GameSession session, QuestLog log) {
    public static LoadedInformation load(GameData data) {
        QuestLog log = createQuestLog(data.quests());
        GameSession session = createGameSession(data.character(), data.map());
        return new LoadedInformation(session, log);
    }
}
