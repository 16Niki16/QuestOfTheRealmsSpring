package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;

public class GameSession {
    private final Gameplay gameplay;
    private final Character character;
    private final CombatService combat;

    public GameSession(Gameplay gameplay, Character character, CombatService combatService) {
        this.gameplay = gameplay;
        this.character = character;
        this.combat = combatService;
    }

    public static GameSession load(Gameplay gameplay, Character character) {
        return new GameSession(gameplay, character, new CombatService());
    }

    public Gameplay gameplay() {
        return this.gameplay;
    }

    public Character character() {
        return this.character;
    }

    public CombatService combat() {
        return this.combat;
    }
}
