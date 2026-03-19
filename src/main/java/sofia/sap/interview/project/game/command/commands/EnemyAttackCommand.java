package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class EnemyAttackCommand implements Command {
    @Override
    public List<CommandResult> execute(User user) {
        GameSession session = user.getSession();
        Enemy enemy = session.gameplay().getEnemyOnCharacterCoordinates();

        return session.combat().defend(session, enemy);
    }
}
