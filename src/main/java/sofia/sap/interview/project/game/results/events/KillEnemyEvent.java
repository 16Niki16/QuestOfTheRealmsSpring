package sofia.sap.interview.project.game.results.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

import static sofia.sap.interview.project.game.results.events.EventType.*;

public record KillEnemyEvent(EventType eventType, String characterName, EnemyType enemyType) implements GameEvent {
    public static KillEnemyEvent of(Character character, Enemy enemy) {
        return new KillEnemyEvent(KILL_ENEMY, character.getCharacterName(), enemy.getType());
    }
}
