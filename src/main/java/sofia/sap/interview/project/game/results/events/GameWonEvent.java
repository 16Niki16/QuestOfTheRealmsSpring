package sofia.sap.interview.project.game.results.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.quests.QuestLog;

import static sofia.sap.interview.project.game.results.events.EventType.*;

public record GameWonEvent(EventType eventType, String characterName, int collectedXP) implements GameEvent {
    public static GameWonEvent of(Character character, QuestLog questLog) {
        return new GameWonEvent(GAME_WON, character.getCharacterName(), questLog.getCollectedXP());
    }
}
