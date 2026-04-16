package sofia.sap.interview.project.game.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import sofia.sap.interview.project.game.characters.ally.type.CharacterType;

public record NewGameRequest(@NotBlank(message = "Character name is required!") String characterName,
                             @NotNull(message = "CharacterType is required!") CharacterType type) {
}
