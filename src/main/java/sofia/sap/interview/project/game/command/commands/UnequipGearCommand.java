package sofia.sap.interview.project.game.command.commands;

import lombok.AllArgsConstructor;
import sofia.sap.interview.project.game.gameplay.ItemsService;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@AllArgsConstructor
public class UnequipGearCommand implements Command {
    private final ItemsService itemsService;
    private final ItemType gear;

    @Override
    public List<CommandResult> execute(User user) {
        synchronized (user) {
            GameSession session = user.getSession();

            return itemsService.unequip(session.character(), gear);
        }
    }
}
