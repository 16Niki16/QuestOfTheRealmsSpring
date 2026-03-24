package sofia.sap.interview.project.game.dto.newgame.mappers;

import sofia.sap.interview.project.game.dto.newgame.ChestDTO;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemFactory;
import sofia.sap.interview.project.game.map.room.Chest;

import java.util.List;
import java.util.stream.IntStream;

public class ChestMapper {
    public static Chest map(ChestDTO dto) {
        if (dto == null || dto.items == null || dto.items.isEmpty()) {
            return null;
        }

        return new Chest(dto.items);
    }
}
