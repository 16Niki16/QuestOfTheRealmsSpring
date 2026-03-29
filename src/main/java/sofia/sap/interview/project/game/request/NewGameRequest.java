package sofia.sap.interview.project.game.request;

import sofia.sap.interview.project.game.characters.ally.type.CharacterType;
import sofia.sap.interview.project.game.exceptions.BadRequestException;

public record NewGameRequest(String characterName, CharacterType type) {
    public NewGameRequest {
        if (characterName == null || type == null) {
            throw new BadRequestException("Character name and type are required!");
        }
    }
}
