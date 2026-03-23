package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.events.AttackEvent;
import sofia.sap.interview.project.game.events.GameOverEvent;
import sofia.sap.interview.project.game.events.DefendEvent;
import sofia.sap.interview.project.game.events.KillEnemyEvent;
import sofia.sap.interview.project.game.events.NotEnoughManaEvent;
import sofia.sap.interview.project.game.map.room.Room;

import java.util.ArrayList;
import java.util.List;

public class CombatService {
    public List<CommandResult> attack(Character character, Enemy currentEnemy, Room currentRoom) {
        List<CommandResult> attackResults = new ArrayList<>();
        int damageDealt = character.attackEnemy();
        if (damageDealt == 0) {
            attackResults.add(new EventResult(NotEnoughManaEvent.of(character, currentEnemy)));
            return attackResults;
        }
        currentEnemy.defendAgainstAllyCharacter(damageDealt);
        attackResults.add(new EventResult(AttackEvent.of(character, damageDealt, currentEnemy)));

        if (currentEnemy.getEnemyStats().isDead()) {
            currentRoom.killEnemy();
            attackResults.add(new EventResult(KillEnemyEvent.of(character, currentEnemy)));
        }

        return attackResults;
    }

    public List<CommandResult> defend(Character character, Enemy currentEnemy) {
        List<CommandResult> enemyAttackResults = new ArrayList<>();
        int damageDealt = currentEnemy.attackDamage();
        character.defendAgainstEnemy(damageDealt);
        enemyAttackResults.add(new EventResult(DefendEvent.of(character, damageDealt, currentEnemy)));

        if (character.getCharacterStats().isDead()) {
            enemyAttackResults.add(new EventResult(GameOverEvent.of(character, currentEnemy)));
        }

        return enemyAttackResults;
    }
}
