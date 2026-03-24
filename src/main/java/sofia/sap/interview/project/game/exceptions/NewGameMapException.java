package sofia.sap.interview.project.game.exceptions;

import sofia.sap.interview.project.game.files.NewGame;

public class NewGameMapException extends RuntimeException {
    public NewGameMapException(String message) {
        super(message);
    }

    public NewGameMapException(String message, Throwable thr) {
        super(message, thr);
    }
}
