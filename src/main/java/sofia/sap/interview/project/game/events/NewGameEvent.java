package sofia.sap.interview.project.game.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.characters.statistics.attack.AttackRange;
import sofia.sap.interview.project.game.characters.statistics.CharacterStatistics;

public record NewGameEvent(EventType eventType, String characterName, AllyCharacterType characterType, int characterHealth, int characterMana,
                           AttackRange characterAttackRange) implements GameEvent {
    public static NewGameEvent of(Character character) {
        CharacterStatistics stats = character.getCharacterStats();
        return new NewGameEvent(EventType.NEW_GAME, character.getCharacterName(), character.getType(),
            stats.getHealth(), stats.getMana(), stats.getAttackRange());
    }
}
