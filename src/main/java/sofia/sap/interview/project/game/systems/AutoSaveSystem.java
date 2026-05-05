package sofia.sap.interview.project.game.systems;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.gameplay.GameSessionService;
import sofia.sap.interview.project.game.user.UserRegistry;

import java.time.Duration;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

@Service
@AllArgsConstructor
public class AutoSaveSystem implements GameSystem {
    private static final Duration TIME_INTERVAL = ofSeconds(60);
    private final GameSessionService gameSessionService;
    private final UserRegistry userRegistry;

    @Override
    public void start(ScheduledExecutorService scheduler) {
        scheduler.scheduleAtFixedRate(() -> userRegistry.getAllUsers().forEach(user -> {
            synchronized (user) {
                if (user.isActiveSession()) {
                    gameSessionService.saveGame(user);
                }
            }
        })
                , TIME_INTERVAL.getSeconds(), TIME_INTERVAL.getSeconds(), TimeUnit.SECONDS);
    }
}
