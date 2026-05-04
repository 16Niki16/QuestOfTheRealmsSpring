package sofia.sap.interview.project.game.systems;

import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.characters.statistics.CharacterStatistics;
import sofia.sap.interview.project.game.user.User;

import java.time.Duration;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

@Service
public class RegenerationSystem implements GameSystem {
    private static final int AMOUNT = 5;
    private static final Duration TIMER = ofSeconds(5);

    @Override
    public void start(ScheduledExecutorService scheduler, Collection<User> activeUsers) {
        scheduler.scheduleAtFixedRate(
                () -> {
                    for (User user : activeUsers) {
                        synchronized (user) {
                            if (user.isActiveSession()) {
                                CharacterStatistics stats = user.getSession().character().getCharacterStats();
                                if (stats.needsRegen()) {
                                    stats.regenerate(AMOUNT);
                                }
                            }
                        }
                    }
                },
                TIMER.getSeconds(), TIMER.getSeconds(), TimeUnit.SECONDS);
    }
}
