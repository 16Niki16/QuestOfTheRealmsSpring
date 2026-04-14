package sofia.sap.interview.project.game.request;

import jakarta.validation.constraints.NotNull;

public record ResumeGameRequest(@NotNull String filename) {
}
