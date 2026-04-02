package sofia.sap.interview.project.game.results.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.quests.QuestLog;

public record GameWonEvent(EventType eventType, String characterName, int collectedXP) implements GameEvent {
    public static GameWonEvent of(Character character, QuestLog questLog) {
        return new GameWonEvent(EventType.GAME_WON, character.getCharacterName(), questLog.getCollectedXP());
    }
}
