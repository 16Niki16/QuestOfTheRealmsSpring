package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.characters.statistics.attack.AttackType;

public record DefendEvent(EventType eventType, String characterName, int damage, EnemyType type, AttackType attackType)
    implements GameEvent {
    public static DefendEvent of(Character character, int damage, Enemy enemy) {
        return new DefendEvent(EventType.DEFEND, character.getCharacterName(),
            damage, enemy.getType(), enemy.attackType());
    }
}
