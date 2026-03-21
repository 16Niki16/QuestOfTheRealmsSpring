package sofia.sap.interview.project.game.systems;

import sofia.sap.interview.project.game.characters.enemy.EnemyState;
import sofia.sap.interview.project.game.command.commands.EnemyAttackCommand;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.events.GameEvent;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.user.User;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EnemyAutoAttackSystem implements GameSystem {
    private static final Duration TIME_INTERVAL = Duration.ofSeconds(1);

    @Override
    public void start(ScheduledExecutorService scheduler, Collection<User> activeUsers) {
        scheduler.scheduleAtFixedRate(() -> {
            for (User user : activeUsers) {
                if (!user.isActiveSession()) {
                    continue;
                }
                Room room = user.getSession().gameplay().getRoom();
                if (room.hasEnemy()) {
                    EnemyState state = room.getState();
                    if (state.canAttack()) {
                        List<CommandResult> results = new EnemyAttackCommand().execute(user);
                        List<GameEvent> events = results.stream()
                            .filter(r -> r instanceof EventResult)
                            .map(r -> ((EventResult) r).event())
                            .toList();
                        state.attacked();
                    }
                }
            }
        }, TIME_INTERVAL.getSeconds(), TIME_INTERVAL.getSeconds(), TimeUnit.SECONDS);
    }
}
