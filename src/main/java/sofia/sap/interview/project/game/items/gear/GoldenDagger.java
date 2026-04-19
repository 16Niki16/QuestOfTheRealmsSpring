package sofia.sap.interview.project.game.items.gear;

import sofia.sap.interview.project.game.items.ItemType;

import static sofia.sap.interview.project.game.items.ItemType.GOLDEN_DAGGER;

public class GoldenDagger extends Dagger {
    private static final int EFFECT = 5;

    @Override
    public ItemType getType() {
        return GOLDEN_DAGGER;
    }

    @Override
    public int getEffect() {
        return EFFECT;
    }

}
