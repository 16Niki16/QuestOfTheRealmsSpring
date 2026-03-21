package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public record DefendEvent(EventType eventType, String characterName, int damage, EnemyType type) implements GameEvent {
    public static DefendEvent of(Character character, int damage, Enemy enemy) {
        return new DefendEvent(EventType.DEFEND, character.getCharacterName(), damage, enemy.getType());
    }
}
