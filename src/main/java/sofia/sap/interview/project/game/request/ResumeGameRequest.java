package sofia.sap.interview.project.game.request;

import jakarta.validation.constraints.NotBlank;

public record ResumeGameRequest(@NotBlank(message = "Filename is required!") String filename) {
}
