package sofia.sap.interview.project.game.systems;

import jakarta.annotation.PreDestroy;
import sofia.sap.interview.project.game.gameplay.GameSessionService;
import sofia.sap.interview.project.game.user.User;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class SystemsStarter {
    private final ScheduledExecutorService scheduler;
    private final GameSessionService gameSessionService;
    private final Collection<User> activeUsers;
    private final List<GameSystem> systems;

    public SystemsStarter(Collection<User> activeUsers, GameSessionService gameSessionService) {
        this.scheduler = Executors.newScheduledThreadPool(2);
        this.activeUsers = activeUsers;
        this.gameSessionService = gameSessionService;
        this.systems = List.of(
                new AutoSaveSystem(gameSessionService),
                new RegenerationSystem());
    }

    public void start() {
        this.systems.forEach(system -> system.start(scheduler, activeUsers));
    }

    @PreDestroy
    public void stop() {
        scheduler.shutdown();
        activeUsers.forEach(gameSessionService::saveGame);
    }
}
