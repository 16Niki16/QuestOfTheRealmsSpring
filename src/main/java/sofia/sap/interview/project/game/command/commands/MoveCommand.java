package sofia.sap.interview.project.game.command.commands;

import lombok.AllArgsConstructor;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.events.CharacterMovedEvent;
import sofia.sap.interview.project.game.gameplay.GameSession;
import sofia.sap.interview.project.game.map.Direction;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.user.User;

import java.util.List;

@AllArgsConstructor
public class MoveCommand implements Command {
    private final Direction direction;

    @Override
    public List<CommandResult> execute(User user) {
        GameSession session = user.getSession();

        synchronized (user) {
            session.campaign().movePlayer(this.direction);
        }

        Room enteredRoom = session.campaign().getRoom();

        return List.of(CharacterMovedEvent.of(session.character(), enteredRoom));
    }
}
