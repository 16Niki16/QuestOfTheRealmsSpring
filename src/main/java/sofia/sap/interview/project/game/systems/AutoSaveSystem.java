package sofia.sap.interview.project.game.systems;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.gameplay.GameSessionService;
import sofia.sap.interview.project.game.user.User;

import java.time.Duration;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class AutoSaveSystem implements GameSystem {
    private static final Duration TIME_INTERVAL = Duration.ofSeconds(60);
    private final GameSessionService gameSessionService;

    @Override
    public void start(ScheduledExecutorService scheduler, Collection<User> activeUsers) {
        scheduler.scheduleAtFixedRate(() -> {
                activeUsers.forEach(user -> {
                    if (user.isActiveSession()) {
                        gameSessionService.saveGame(user);
                    }
                });
            }
            , TIME_INTERVAL.getSeconds(), TIME_INTERVAL.getSeconds(), TimeUnit.SECONDS);
    }
}
