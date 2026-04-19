package sofia.sap.interview.project.game.command.commands;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.exceptions.NoEnemyInTheRoomException;
import sofia.sap.interview.project.game.gameplay.CombatService;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.user.User;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class AttackCommand implements Command {
    private final CombatService combatService;

    @Override
    public List<CommandResult> execute(User user) {
        GameSession session = user.getSession();
        Room room = session.campaign().getRoom();
        Enemy enemy = room.getEnemy();

        if (enemy == null) {
            throw new NoEnemyInTheRoomException("There is no enemy in the current room!");
        }

        Character character = session.character();

        List<CommandResult> results = new ArrayList<>();

        synchronized (user) {
            results.addAll(combatService.attack(character, enemy, room));
            results.addAll(combatService.defend(character, enemy));
        }

        return results;
    }

}
