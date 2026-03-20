package sofia.sap.interview.project.game.request;

import sofia.sap.interview.project.game.characters.ally.type.AllyCharacterType;

public record NewGameRequest(String username, String characterName, AllyCharacterType type) {
}
