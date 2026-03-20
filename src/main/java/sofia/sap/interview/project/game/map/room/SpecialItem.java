package sofia.sap.interview.project.game.map.room;

import lombok.Getter;

@Getter
public enum SpecialItem {
    IRON_KEY("iron key"),
    TORCH("torch");
    private final String name;

    SpecialItem(String name) {
        this.name = name;
    }

}
