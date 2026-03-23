package sofia.sap.interview.project.game.request;

import sofia.sap.interview.project.game.exceptions.BadRequestException;

public record CommandRequest(String command) {
    public CommandRequest {
        if (command == null) {
            throw new BadRequestException("Command is null!");
        }
    }
}
