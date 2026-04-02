package sofia.sap.interview.project.game.results.information;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.statistics.CharacterStatistics;
import sofia.sap.interview.project.game.map.room.Room;

public record ResumeInformation(ViewType viewType, String characterName, String locationName, int health, int mana)
    implements ViewInformation {
    public static ResumeInformation of(Character character, Room currentRoom) {
        CharacterStatistics characterStatistics = character.getCharacterStats();

        return new ResumeInformation(ViewType.RESUME, character.getCharacterName(), currentRoom.getName(),
            characterStatistics.getHealth(), characterStatistics.getMana());
    }
}
