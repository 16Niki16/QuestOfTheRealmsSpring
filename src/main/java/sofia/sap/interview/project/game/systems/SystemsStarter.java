package sofia.sap.interview.project.game.systems;

import sofia.sap.interview.project.game.user.User;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class SystemsStarter {
    private final ScheduledExecutorService scheduler;
    private final Set<User> activeUsers;
    private final List<GameSystem> systems;

    public SystemsStarter(Set<User> activeUsers) {
        this.scheduler = Executors.newScheduledThreadPool(2);
        this.activeUsers = activeUsers;
        this.systems = List.of(
                new AutoSaveSystem(),
                new RegenerationSystem(),
                new EnemyAutoAttackSystem());
    }

    public void start() {
        for (GameSystem system : this.systems) {
            system.start(scheduler, activeUsers);
        }
    }

    public void stop() {
        scheduler.shutdown();
    }
}
