package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class OpenChestCommand implements Command {
    @Override
    public List<CommandResult> execute(User user) {
        GameSession gameSession = user.getSession();
        Character character = gameSession.getCharacter();
        Room currentRoom = gameSession.getCampaign().getRoom();
        return gameSession.getItemsService().collect(character, currentRoom);
    }
}
