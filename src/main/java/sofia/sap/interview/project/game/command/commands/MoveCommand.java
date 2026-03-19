package sofia.sap.interview.project.game.command.commands;

import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.events.CharacterMovedEvent;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.map.Direction;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

public class MoveCommand implements Command {
    private final Direction direction;

    public MoveCommand(Direction direction) {
        this.direction = direction;
    }

    @Override
    public List<CommandResult> execute(User user) {
        GameSession session = user.getSession();
        session.gameplay().movePlayer(this.direction);
        return List.of(new EventResult(CharacterMovedEvent.of(session.character(), session.gameplay().getRoom())));
    }
}
