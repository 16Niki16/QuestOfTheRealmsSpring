package sofia.sap.interview.project.game.command.commands;

import lombok.AllArgsConstructor;
import sofia.sap.interview.project.game.gameplay.ItemsService;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@AllArgsConstructor
public class UseItemCommand implements Command {
    private final ItemsService itemsService;
    private final ItemType item;

    @Override
    public List<CommandResult> execute(User user) {
        GameSession session = user.getSession();

        synchronized (user) {
            return itemsService.useItem(session.character(), this.item);
        }
    }
}
