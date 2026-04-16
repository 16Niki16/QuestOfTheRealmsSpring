package sofia.sap.interview.project.game.request;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(@NotBlank(message = "Username is required!") String username) {
}
