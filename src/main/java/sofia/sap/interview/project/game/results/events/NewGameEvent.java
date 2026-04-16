package sofia.sap.interview.project.game.results.events;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.type.CharacterType;
import sofia.sap.interview.project.game.characters.statistics.CharacterStatistics;
import sofia.sap.interview.project.game.characters.statistics.attack.AttackRange;

import static sofia.sap.interview.project.game.results.events.EventType.*;

public record NewGameEvent(EventType eventType, String characterName, CharacterType characterType,
                           int characterHealth, int characterMana, AttackRange characterAttackRange)
        implements GameEvent {

    public static NewGameEvent of(Character character) {
        CharacterStatistics stats = character.getCharacterStats();

        return new NewGameEvent(NEW_GAME, character.getCharacterName(), character.getType(),
                stats.getHealth(), stats.getMana(), stats.getAttackRange());
    }
}
