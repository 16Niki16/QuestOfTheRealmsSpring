package sofia.sap.interview.project.game.request;

import jakarta.validation.constraints.NotNull;
import sofia.sap.interview.project.game.characters.ally.type.CharacterType;
import sofia.sap.interview.project.game.exceptions.BadRequestException;

public record NewGameRequest(@NotNull String characterName, @NotNull CharacterType type) {
}
