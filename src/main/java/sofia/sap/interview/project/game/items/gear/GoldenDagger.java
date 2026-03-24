package sofia.sap.interview.project.game.items.gear;

import sofia.sap.interview.project.game.items.ItemType;

public class GoldenDagger extends Dagger {
    private static final int EFFECT = 5;

    @Override
    public ItemType getType() {
        return ItemType.GOLDEN_DAGGER;
    }

    @Override
    public int getEffect() {
        return EFFECT;
    }

}
