package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public record KillEnemyEvent(EventType event, String characterName, EnemyType type) implements GameEvent {
    public static KillEnemyEvent of(Character character, Enemy enemy) {
        return new KillEnemyEvent(EventType.KILL_ENEMY, character.getCharacterName(), enemy.getType());
    }
}
