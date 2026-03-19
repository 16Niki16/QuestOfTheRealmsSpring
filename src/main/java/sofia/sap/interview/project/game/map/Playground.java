package sofia.sap.interview.project.game.map;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.map.room.Room;
import sofia.sap.interview.project.game.map.room.SpecialItem;

import java.util.HashSet;
import java.util.Set;

public record Playground(Room[][] rooms) {

    /**
     * (0,0) x -->
     * y
     * |
     * raste nadolu
     */
    @Override
    public Room[][] rooms() {
        return this.rooms;
    }

    public boolean canMove(Coordinates playerPosition, Direction direction) {
        Coordinates next = direction.move(playerPosition);
        return isInside(next);
    }

    public Set<Direction> possibleDirections(Coordinates playerCoordinates) {
        Set<Direction> directions = new HashSet<>();

        for (Direction direction : Direction.values()) {
            if (canMove(playerCoordinates, direction)) {
                directions.add(direction);
            }
        }
        return directions;
    }

    private boolean isInside(Coordinates c) {
        return c.y() >= 0 && c.y() < rooms.length
            && c.x() >= 0 && c.x() < rooms[c.y()].length;
    }

    public Enemy getEnemyByPosition(Coordinates coordinates) {
        return rooms[coordinates.y()][coordinates.x()].getEnemy();
    }

    public SpecialItem getSpecialItemByPosition(Coordinates coordinates) {
        return rooms[coordinates.y()][coordinates.x()].getSpecialItem();
    }

    public Room getRoomByCoordinates(Coordinates coordinates) {
        return rooms[coordinates.y()][coordinates.x()];
    }
}
