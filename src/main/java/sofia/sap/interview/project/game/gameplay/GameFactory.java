package sofia.sap.interview.project.game.gameplay;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.type.CharacterType;
import sofia.sap.interview.project.game.files.NewGame;

public class GameFactory {
    public static GameSession createSession(String characterName, CharacterType characterType) {
        Campaign campaign = new Campaign(NewGame.createPlayground());
        Character character = Character.createNewCharacter(characterName, characterType);

        return new GameSession(campaign, character);
    }
}
