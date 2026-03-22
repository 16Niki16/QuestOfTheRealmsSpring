package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;

public class GameSession {

    private final Character character;
    private final Campaign campaign;
    private final CombatService combat;

    public GameSession(Campaign campaign, Character character, CombatService combatService) {
        this.campaign = campaign;
        this.character = character;
        this.combat = combatService;
    }

    public static GameSession load(Campaign campaign, Character character) {
        return new GameSession(campaign, character, new CombatService());
    }

    public Campaign gameplay() {
        return this.campaign;
    }

    public Character character() {
        return this.character;
    }

    public CombatService combat() {
        return this.combat;
    }
}
