package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.map.room.Room;

public record CharacterMovedEvent(EventType eventType, String characterName, String roomName) implements GameEvent {
    public static CharacterMovedEvent of(Character character, Room room) {
        return new CharacterMovedEvent(EventType.MOVE, character.getCharacterName(), room.getName());
    }

}
