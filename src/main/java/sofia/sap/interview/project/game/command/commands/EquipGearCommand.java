package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.items.ItemType;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class EquipGearCommand implements Command {
    private final ItemType gear;

    public EquipGearCommand(ItemType gear) {
        this.gear = gear;
    }

    @Override
    public List<CommandResult> execute(User user) {
        GameSession session = user.getSession();
        return session.combat().equip(session.character(), this.gear);
    }
}
