package sofia.sap.interview.project.game.gameplay;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.characters.ally.type.CharacterType;
import sofia.sap.interview.project.game.files.MapService;
import sofia.sap.interview.project.game.quests.QuestLog;

import static sofia.sap.interview.project.game.characters.ally.Character.createNewCharacter;
import static sofia.sap.interview.project.game.gameplay.Campaign.createNewCampaign;
import static sofia.sap.interview.project.game.quests.QuestLog.createNewQuestLog;

@Component
@AllArgsConstructor
public class GameFactory {
    private final MapService mapService;

    public GameSession createSession(String sessionName, String characterName, CharacterType characterType) {
        Campaign campaign = createNewCampaign(mapService.createPlayground());
        Character character = createNewCharacter(characterName, characterType);
        QuestLog questLog = createNewQuestLog();

        return new GameSession(sessionName, campaign, character, questLog);
    }
}
