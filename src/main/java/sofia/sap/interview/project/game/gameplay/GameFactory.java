package sofia.sap.interview.project.game.gameplay;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.type.CharacterType;
import sofia.sap.interview.project.game.files.MapService;

import static sofia.sap.interview.project.game.characters.ally.Character.createNewCharacter;
import static sofia.sap.interview.project.game.gameplay.Campaign.*;

@Component
@AllArgsConstructor
public class GameFactory {
    private final MapService mapService;

    public GameSession createSession(String characterName, CharacterType characterType) {
        Campaign campaign =  createNewCampaign(mapService.createPlayground());
        Character character = createNewCharacter(characterName, characterType);

        return new GameSession(campaign, character);
    }
}
