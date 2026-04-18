package sofia.sap.interview.project.game.command.commands;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import sofia.sap.interview.project.game.characters.ally.Character;
import sofia.sap.interview.project.game.gameplay.ItemsService;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@Component
@AllArgsConstructor
public class OpenChestCommand implements Command {
    private final ItemsService itemsService;

    @Override
    public List<CommandResult> execute(User user) {
        GameSession gameSession = user.getSession();
        Character character = gameSession.character();
        Room currentRoom = gameSession.campaign().getRoom();

        synchronized (user) {
            return itemsService.collect(character, currentRoom);
        }
    }
}
