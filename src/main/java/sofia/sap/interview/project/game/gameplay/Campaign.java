package sofia.sap.interview.project.game.gameplay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.results.CommandResult;
import sofia.sap.interview.project.game.results.events.CollectSpecialItemEvent;
import sofia.sap.interview.project.game.exceptions.DirectionNotAvailableException;
import sofia.sap.interview.project.game.results.information.RoomInformation;
import sofia.sap.interview.project.game.map.Coordinates;
import sofia.sap.interview.project.game.map.Direction;
import sofia.sap.interview.project.game.map.Playground;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.map.room.SpecialItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static sofia.sap.interview.project.game.map.Coordinates.*;

@Getter
@AllArgsConstructor
public class Campaign {
    private final Playground playground;
    private Coordinates playerCoordinates;

    public static Campaign createNewCampaign(Playground playground) {
        return new Campaign(playground, startingCoordinates());
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
        List<CommandResult> resultList = new ArrayList<>();
        Room currentRoom = getRoom();
        SpecialItem specialItem = currentRoom.getSpecialItem();
        resultList.add(RoomInformation.of(currentRoom));

        if (specialItem != null) {
            currentRoom.collectSpecialItem();
            resultList.add(CollectSpecialItemEvent.of(specialItem));
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
