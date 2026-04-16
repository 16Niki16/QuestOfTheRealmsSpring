package sofia.sap.interview.project.game.results.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

import static sofia.sap.interview.project.game.results.events.EventType.*;

public record NotEnoughManaEvent(EventType eventType, String characterName, EnemyType enemyType) implements GameEvent {
    public static NotEnoughManaEvent of(Character character, Enemy enemy) {
        return new NotEnoughManaEvent(NOT_ENOUGH_MANA, character.getCharacterName(), enemy.getType());
    }
}
