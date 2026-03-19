package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class AttackCommand implements Command {

    @Override
    public List<CommandResult> execute(User user) {
        GameSession session = user.getSession();
        Enemy enemy = session.gameplay().getEnemyOnCharacterCoordinates();
        Character character = session.character();
        Room room = session.gameplay().getRoom();

        return session.combat().attack(character, enemy, room);
    }

}
