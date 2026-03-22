package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.exceptions.NoEnemyInTheRoomException;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.user.User;

import java.util.ArrayList;
import java.util.List;

public class AttackCommand implements Command {

    @Override
    public List<CommandResult> execute(User user) {
        GameSession session = user.getSession();
        Enemy enemy = session.getCampaign().getEnemyOnCharacterCoordinates();
        if (enemy == null) {
            throw new NoEnemyInTheRoomException("There is no enemy in the current room!");
        }
        Character character = session.getCharacter();
        Room room = session.getCampaign().getRoom();

        List<CommandResult> results = new ArrayList<>();
        results.addAll(session.getCombatService().attack(character, enemy, room));
        results.addAll(session.getCombatService().defend(character, enemy));
        return results;
    }

}
