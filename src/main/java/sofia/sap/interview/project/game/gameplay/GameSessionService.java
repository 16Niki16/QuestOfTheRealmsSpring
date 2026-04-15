package sofia.sap.interview.project.game.gameplay;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sofia.sap.interview.project.game.characters.ally.type.CharacterType;
import sofia.sap.interview.project.game.files.GameRepositoryService;
import sofia.sap.interview.project.game.quests.QuestLog;
import sofia.sap.interview.project.game.user.User;

import static sofia.sap.interview.project.game.quests.QuestLog.createNewQuestLog;

@Service
@AllArgsConstructor
public class GameSessionService {
    private final GameFactory gameFactory;
    private final GameRepositoryService gameRepositoryService;

    public void newGame(User user, String characterName, CharacterType characterType) {
        String fileName = gameRepositoryService.getNewGameFilename(user);
        GameSession session = gameFactory.createSession(characterName, characterType);
        QuestLog log = createNewQuestLog();

        user.createSession(fileName, session, log);
    }
}
