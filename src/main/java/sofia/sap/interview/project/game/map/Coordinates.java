package sofia.sap.interview.project.game.map;

public record Coordinates(int x, int y) {
    public static Coordinates startingCoordinates() {
        return new Coordinates(0, 0);
    }
}
