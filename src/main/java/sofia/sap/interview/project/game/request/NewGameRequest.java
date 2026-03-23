package sofia.sap.interview.project.game.request;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;
import sofia.sap.interview.project.game.exceptions.BadRequestException;

public record NewGameRequest(String characterName, AllyCharacterType type) {
    public NewGameRequest {
        if (characterName == null || type == null) {
            throw new BadRequestException("Character name and type are required!");
        }
    }
}
