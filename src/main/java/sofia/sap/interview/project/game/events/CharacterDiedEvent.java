package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public record CharacterDiedEvent(EventType type, String characterName, EnemyType enemyType) implements GameEvent {
    public static CharacterDiedEvent of(Character character, Enemy enemy) {
        return new CharacterDiedEvent(EventType.CHARACTER_DIED, character.getCharacterName(), enemy.getType());
    }
}
