package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.dto.savegame.data.ChestData;
import sofia.sap.interview.project.game.items.Item;
import sofia.sap.interview.project.game.items.ItemFactory;
import sofia.sap.interview.project.game.map.room.Chest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChestFactory {
    public static Chest create(ChestData data) {
        List<Item> items = data.items().entrySet().stream()
                .flatMap(entry -> IntStream.range(0, entry.getValue())
                        .mapToObj(i -> ItemFactory.create(entry.getKey())))
                .collect(Collectors.toCollection(ArrayList::new));

        return Chest.createChest(items);
    }
}
