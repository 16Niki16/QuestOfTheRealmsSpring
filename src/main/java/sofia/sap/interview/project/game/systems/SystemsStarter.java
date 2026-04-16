package sofia.sap.interview.project.game.systems;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.user.UserRegistry;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Component
@RequiredArgsConstructor
public class SystemsStarter {
    private final AutoSaveSystem autoSaveSystem;
    private final RegenerationSystem regenerationSystem;
    private final UserRegistry userRegistry;
    private ScheduledExecutorService scheduler;

    @PostConstruct
    public void start() {
        scheduler = Executors.newScheduledThreadPool(2);

        autoSaveSystem.start(scheduler, userRegistry.getAllUsers());
        regenerationSystem.start(scheduler, userRegistry.getAllUsers());
    }

    @PreDestroy
    public void stop() {
        if (scheduler != null) {
            scheduler.shutdownNow();
        }
    }
}
