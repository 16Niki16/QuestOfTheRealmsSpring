package sofia.sap.interview.project.game.request;

import sofia.sap.interview.project.game.exceptions.BadRequestException;

public record ResumeGameRequest(String filename) {
    public ResumeGameRequest {
        if (filename == null) {
            throw new BadRequestException("The name of the file can not be null!");
        }
    }
}
