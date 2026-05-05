package sofia.sap.interview.project.game.results.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.characters.statistics.attack.AttackType;

import static sofia.sap.interview.project.game.results.events.EventType.DEFEND;

public record DefendEvent(EventType eventType, String characterName, int damage, EnemyType type, AttackType attackType)
        implements GameEvent {
    public static DefendEvent of(Character character, int damage, Enemy enemy) {
        return new DefendEvent(DEFEND, character.getCharacterName(),
                damage, enemy.getType(), enemy.attackType());
    }
}
