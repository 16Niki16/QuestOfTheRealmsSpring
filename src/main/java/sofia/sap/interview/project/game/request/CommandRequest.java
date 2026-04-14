package sofia.sap.interview.project.game.request;

import jakarta.validation.constraints.NotNull;

public record CommandRequest(@NotNull String command) {
}
