package sofia.sap.interview.project.game.systems;

import sofia.sap.interview.project.game.user.User;

import java.time.Duration;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AutoSaveSystem implements GameSystem {
    private static final Duration TIME_INTERVAL = Duration.ofSeconds(60);

    @Override
    public void start(ScheduledExecutorService scheduler, Collection<User> activeUsers) {
        scheduler.scheduleAtFixedRate(() -> {
            for (User user : activeUsers) {
                if (user.isActiveSession()) {
                    user.save();
                }
            }
        }, TIME_INTERVAL.getSeconds(), TIME_INTERVAL.getSeconds(), TimeUnit.SECONDS);
    }
}
