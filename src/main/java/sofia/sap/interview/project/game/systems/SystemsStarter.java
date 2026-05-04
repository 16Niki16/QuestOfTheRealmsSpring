package sofia.sap.interview.project.game.systems;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.gameplay.GameSessionService;
import sofia.sap.interview.project.game.user.UserRegistry;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class SystemsStarter {
    private static final int TIMEOUT = 5;
    private static final int NUMBER_OF_THREADS = 2;

    private final AutoSaveSystem autoSaveSystem;
    private final RegenerationSystem regenerationSystem;
    private final UserRegistry userRegistry;
    private final GameSessionService gameSessionService;
    private ScheduledExecutorService scheduler;

    @PostConstruct
    public void start() {
        scheduler = Executors.newScheduledThreadPool(NUMBER_OF_THREADS);

        autoSaveSystem.start(scheduler);
        regenerationSystem.start(scheduler);
    }

    @PreDestroy
    public void stop() {
        if (scheduler != null) {
            scheduler.shutdown();

            try {
                if (!scheduler.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                    scheduler.shutdownNow();
                }
            } catch (InterruptedException e) {
                scheduler.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }

        userRegistry.getAllUsers().forEach(gameSessionService::saveGame);
    }
}
