package sofia.sap.interview.project.game.results.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public record AttackEvent(EventType eventType, String characterName, int damage, EnemyType type) implements GameEvent {
    public static AttackEvent of(Character character, int damage, Enemy enemy) {
        return new AttackEvent(EventType.ATTACK, character.getCharacterName(), damage, enemy.getType());
    }
}
