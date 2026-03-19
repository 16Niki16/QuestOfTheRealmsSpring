package sofia.sap.interview.project.game.information;

import sofia.sap.interview.project.game.map.Direction;

import java.util.Set;

public record PathsInformation(Set<Direction> directions) implements ViewInformation{
}
