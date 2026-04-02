package sofia.sap.interview.project.game.results.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public record GameOverEvent(EventType eventType, String characterName, EnemyType enemyType) implements GameEvent {
    public static GameOverEvent of(Character character, Enemy enemy) {
        return new GameOverEvent(EventType.GAME_OVER, character.getCharacterName(), enemy.getType());
    }
}
