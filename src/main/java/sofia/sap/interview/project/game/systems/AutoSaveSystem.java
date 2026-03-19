package sofia.sap.interview.project.game.systems;

import sofia.sap.interview.project.game.files.SaveGame;
import sofia.sap.interview.project.game.user.User;

import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AutoSaveSystem implements GameSystem {
    private static final int TIME_INTERVAL = 60;

    @Override
    public void start(ScheduledExecutorService scheduler, Set<User> users) {
        scheduler.scheduleAtFixedRate(() -> {
            for (User user : users) {
                if (user.isActiveSession()) {
                    SaveGame.saveGame(user);
                }
            }
        }, TIME_INTERVAL, TIME_INTERVAL, TimeUnit.SECONDS);
    }
}
