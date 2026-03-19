package sofia.sap.interview.project.game.systems;

import sofia.sap.interview.project.game.user.User;

import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public interface GameSystem {
    void start(ScheduledExecutorService scheduler, Set<User> activeUsers);
}
