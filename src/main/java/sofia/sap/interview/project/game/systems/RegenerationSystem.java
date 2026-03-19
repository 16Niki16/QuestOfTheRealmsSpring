package sofia.sap.interview.project.game.systems;

import sofia.sap.interview.project.game.user.User;

import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RegenerationSystem implements GameSystem {
    private static final int AMOUNT = 5;
    private static final int TIMER = 5;

    @Override
    public void start(ScheduledExecutorService scheduler, Set<User> users) {
        scheduler.scheduleAtFixedRate(
            () -> {
                for (User user : users) {
                    user.getSession().character().regen(AMOUNT);
                }
            },
            TIMER, TIMER, TimeUnit.SECONDS);
    }
}
