package sofia.sap.interview.project.game.gameplay;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.ally.Character;

@Getter
public class GameSession {

    private final Character character;
    private final Campaign campaign;
    private final CombatService combatService;
    private final ItemsService itemsService;

    public GameSession(Campaign campaign, Character character) {
        this.campaign = campaign;
        this.character = character;
        this.combatService = new CombatService();
        this.itemsService = new ItemsService();
    }

    public static GameSession load(Campaign campaign, Character character) {
        return new GameSession(campaign, character);
    }
}
