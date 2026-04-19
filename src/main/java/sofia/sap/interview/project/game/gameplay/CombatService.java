package sofia.sap.interview.project.game.gameplay;

import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.events.AttackEvent;
import sofia.sap.interview.project.game.results.events.DefendEvent;
import sofia.sap.interview.project.game.results.events.GameOverEvent;
import sofia.sap.interview.project.game.results.events.KillEnemyEvent;
import sofia.sap.interview.project.game.results.events.NotEnoughManaEvent;

import java.util.ArrayList;
import java.util.List;

@Service
public class CombatService {
    public List<CommandResult> attack(Character character, Enemy currentEnemy, Room currentRoom) {
        List<CommandResult> attackResults = new ArrayList<>();
        int damageDealt = character.attackEnemy();

        if (damageDealt == 0) {
            attackResults.add(NotEnoughManaEvent.of(character, currentEnemy));
            return attackResults;
        }

        currentEnemy.defendAgainstAllyCharacter(damageDealt);
        attackResults.add(AttackEvent.of(character, damageDealt, currentEnemy));

        if (currentEnemy.getEnemyStats().isDead()) {
            currentRoom.removeEnemy();
            attackResults.add(KillEnemyEvent.of(character, currentEnemy));
        }

        return attackResults;
    }

    public List<CommandResult> defend(Character character, Enemy currentEnemy) {
        List<CommandResult> enemyAttackResults = new ArrayList<>();
        int damageDealt = currentEnemy.attackDamage();
        character.defendAgainstEnemy(damageDealt);
        enemyAttackResults.add(DefendEvent.of(character, damageDealt, currentEnemy));

        if (character.getCharacterStats().isDead()) {
            enemyAttackResults.add(GameOverEvent.of(character, currentEnemy));
        }

        return enemyAttackResults;
    }
}
