package sofia.sap.interview.project.game.gameplay;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.ally.Character;

import java.util.concurrent.ScheduledFuture;

@Getter
public class GameSession {

    private final Character character;
    private final Campaign campaign;
    private final CombatService combatService;
    private final ItemsService itemsService;
    private volatile ScheduledFuture<?> regenTask;

    public GameSession(Campaign campaign, Character character) {
        this.campaign = campaign;
        this.character = character;
        this.combatService = new CombatService();
        this.itemsService = new ItemsService();
    }

    public void setRegenTask(ScheduledFuture<?> regenTask) {
        this.regenTask = regenTask;
    }

    public void stopRegen() {
        if (regenTask != null) {
            regenTask.cancel(false);
            regenTask = null;
        }
    }
}
