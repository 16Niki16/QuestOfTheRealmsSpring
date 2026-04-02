package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.results.information.ResumeInformation;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class ResumeCommand implements Command {
    private final String filename;

    public ResumeCommand(String filename) {
        this.filename = filename;
    }

    @Override
    public List<CommandResult> execute(User user) {
        user.resumeGame(filename);
        GameSession gameSession = user.getSession();
        Character character = gameSession.getCharacter();
        Room currentRoom = gameSession.getCampaign().getRoom();

        return List.of(ResumeInformation.of(character, currentRoom));
    }
}
