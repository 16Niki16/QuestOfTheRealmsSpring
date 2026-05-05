package sofia.sap.interview.project.game.systems;

import java.util.concurrent.ScheduledExecutorService;

public interface GameSystem {
    void start(ScheduledExecutorService scheduler);
}
