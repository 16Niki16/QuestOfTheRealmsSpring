package sofia.sap.interview.project.game.gameplay;

import lombok.Getter;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.command.result.CommandResult;
import sofia.sap.interview.project.game.command.result.EventResult;
import sofia.sap.interview.project.game.command.result.ViewResult;
import sofia.sap.interview.project.game.events.CollectSpecialItemEvent;
import sofia.sap.interview.project.game.exceptions.DirectionNotAvailableException;
import sofia.sap.interview.project.game.information.RoomInformation;
import sofia.sap.interview.project.game.map.Coordinates;
import sofia.sap.interview.project.game.map.Direction;
import sofia.sap.interview.project.game.map.Playground;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.map.room.SpecialItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
public class Campaign {
    private final Playground playground;
    private Coordinates playerCoordinates;

    public Campaign(Playground playground) {
        this.playground = playground;
        this.playerCoordinates = Coordinates.startingCoordinates();
    }

    public Campaign(Playground playground, Coordinates coordinates) {
        this.playground = playground;
        this.playerCoordinates = coordinates;
    }

    public void movePlayer(Direction direction) {
        if (playground.canMove(this.playerCoordinates, direction)) {
            this.playerCoordinates = direction.move(this.playerCoordinates);
        } else {
            throw new DirectionNotAvailableException(
                    "The provided direction is not correct, choose another direction!");
        }
    }

    public List<CommandResult> lookAround() {
        Room room = getRoom();
        List<CommandResult> resultList = new ArrayList<>();
        Enemy enemy = room.getEnemy();
        EnemyType enemyType = enemy != null ? enemy.getType() : null;
        SpecialItem specialItem = room.getSpecialItem();
        resultList.add(new ViewResult(new RoomInformation(getRoom().hasChest(),
                enemyType, specialItem)));

        if (specialItem != null) {
            room.collectSpecialItem();
            resultList.add(new EventResult(CollectSpecialItemEvent.of(specialItem)));
        }

        return resultList;
    }

    public Set<Direction> getPossibleDirections() {
        return this.playground.possibleDirections(this.playerCoordinates);
    }

    public Enemy getEnemyOnCharacterCoordinates() {
        return playground.getEnemyByPosition(playerCoordinates);
    }

    public Room getRoom() {
        return this.playground.getRoomByCoordinates(this.playerCoordinates);
    }
}
