package sofia.sap.interview.project.game.results.information;

import sofia.sap.interview.project.game.map.Direction;

import java.util.Set;

public record PathsInformation(ViewType viewType, Set<Direction> directions) implements ViewInformation {
    public static PathsInformation of(Set<Direction> directions) {
        return new PathsInformation(ViewType.PATHS, directions);
    }
}
