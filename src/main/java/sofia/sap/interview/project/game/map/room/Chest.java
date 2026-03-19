package sofia.sap.interview.project.game.map.room;

import sofia.sap.interview.project.game.items.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Chest {
    private final Collection<Item> content;

    private Chest(Collection<Item> content) {
        this.content = new ArrayList<>(content);
    }

    public static Chest createChest(List<Item> content) {
        return new Chest(content);
    }

    public Collection<Item> getContent() {
        return this.content;
    }

    public Collection<Item> collectItems() {
        Collection<Item> items = List.copyOf(this.content);
        this.content.clear();
        return items;
    }
}
