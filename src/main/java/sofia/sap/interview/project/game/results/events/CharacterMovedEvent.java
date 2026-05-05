package sofia.sap.interview.project.game.results.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.map.room.Room;

import static sofia.sap.interview.project.game.results.events.EventType.MOVE;

public record CharacterMovedEvent(EventType eventType, String characterName, String roomName) implements GameEvent {
    public static CharacterMovedEvent of(Character character, Room room) {
        return new CharacterMovedEvent(MOVE, character.getCharacterName(), room.getName());
    }

}
