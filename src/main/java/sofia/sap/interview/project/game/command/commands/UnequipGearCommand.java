package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class UnequipGearCommand implements Command {
    private final ItemType gear;

    public UnequipGearCommand(ItemType gear) {
        this.gear = gear;
    }

    @Override
    public List<CommandResult> execute(User user) {
        synchronized (user) {
            GameSession session = user.getSession();

            return session.getItemsService().unequip(session.getCharacter(), gear);
        }
    }
}
