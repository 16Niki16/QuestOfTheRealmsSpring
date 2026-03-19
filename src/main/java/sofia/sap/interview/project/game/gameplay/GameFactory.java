package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.files.NewGame;

public class GameFactory {
    public static GameSession createSession(String characterName, AllyCharacterType type) {
        Gameplay gameplay = new Gameplay(NewGame.createPlayground());
        Character character = new Character(characterName, type);
        CombatService actions = new CombatService();
        return new GameSession(gameplay, character, actions);
    }
}
