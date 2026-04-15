package sofia.sap.interview.project.game.gameplay;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.type.CharacterType;
import sofia.sap.interview.project.game.files.MapService;

@Component
@AllArgsConstructor
public class GameFactory {
    private final MapService mapService;

    public GameSession createSession(String characterName, CharacterType characterType) {
        Campaign campaign = new Campaign(mapService.createPlayground());
        Character character = Character.createNewCharacter(characterName, characterType);

        return new GameSession(campaign, character);
    }
}
