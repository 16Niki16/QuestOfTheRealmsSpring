package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.files.NewGame;

public class GameFactory {
    public static GameSession createSession(String characterName, AllyCharacterType type) {
        Campaign campaign = new Campaign(NewGame.createPlayground());
        Character character = new Character(characterName, type);

        return new GameSession(campaign, character);
    }
}
