package sofia.sap.interview.project.game.systems;

import sofia.sap.interview.project.game.characters.statistics.CharacterStatistics;
import sofia.sap.interview.project.game.user.User;

import java.time.Duration;
import java.util.Collection;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RegenerationSystem implements GameSystem {
    private static final int AMOUNT = 5;
    private static final Duration TIMER = Duration.ofSeconds(5);

    @Override
    public void start(ScheduledExecutorService scheduler, Collection<User> activeUsers) {
        scheduler.scheduleAtFixedRate(
                () -> {
                    for (User user : activeUsers) {
                        if (user.isActiveSession()) {
                            CharacterStatistics stats = user.getSession().getCharacter().getCharacterStats();
                            stats.regenerate(AMOUNT);
                        }
                    }
                },
                TIMER.getSeconds(), TIMER.getSeconds(), TimeUnit.SECONDS);
    }
}
