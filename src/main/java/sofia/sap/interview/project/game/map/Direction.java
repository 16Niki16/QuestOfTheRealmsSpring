package sofia.sap.interview.project.game.map;

import sofia.sap.interview.project.game.exceptions.DirectionNotAvailableException;

public enum Direction {
    SOUTH(0, 1, "south"),
    NORTH(0, -1, "north"),
    EAST(1, 0, "east"),
    WEST(-1, 0, "west");

    private final int dx;
    private final int dy;
    private final String direction;

    Direction(int dx, int dy, String direction) {
        this.dx = dx;
        this.dy = dy;
        this.direction = direction;
    }

    public Coordinates move(Coordinates from) {
        return new Coordinates(from.x() + dx, from.y() + dy);
    }

    public static Direction getDirection(String input) {
        for (Direction dir : values()) {
            if (dir.direction.equals(input)) {
                return dir;
            }
        }
        throw new DirectionNotAvailableException("The provided direction is not in the list!");
    }
}
