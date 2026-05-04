package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.quests.QuestLog;

public record GameSession(String sessionName, Campaign campaign, Character character, QuestLog log) {

}
