package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class UseItemCommand implements Command {
    private final ItemType item;

    public UseItemCommand(ItemType item) {
        this.item = item;
    }

    @Override
    public List<CommandResult> execute(User user) {
        GameSession session = user.getSession();

        synchronized (user) {
            return session.getItemsService().useItem(session.getCharacter(), this.item);
        }
    }
}
