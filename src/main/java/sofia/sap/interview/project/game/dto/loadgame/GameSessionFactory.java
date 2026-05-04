package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.dto.data.GameData;
import sofia.sap.interview.project.game.gameplay.Campaign;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.quests.QuestLog;

import static sofia.sap.interview.project.game.dto.loadgame.MapFactory.createCampaign;
import static sofia.sap.interview.project.game.dto.loadgame.QuestLogFactory.createQuestLog;

public class GameSessionFactory {
    public static GameSession createGameSession(GameData data) {
        Character character = CharacterFactory.create(data.character());
        Campaign campaign = createCampaign(data.map());
        QuestLog log = createQuestLog(data.quests());

        return new GameSession(data.sessionName(), campaign, character, log);
    }
}
