package sofia.sap.interview.project.game.items.gear;

import sofia.sap.interview.project.game.items.ItemType;

import static sofia.sap.interview.project.game.items.ItemType.GOLDEN_SWORD;

public class GoldenSword extends Sword {
    private static final int EFFECT = 6;

    @Override
    public ItemType getType() {
        return GOLDEN_SWORD;
    }

    @Override
    public int getEffect() {
        return EFFECT;
    }
}
