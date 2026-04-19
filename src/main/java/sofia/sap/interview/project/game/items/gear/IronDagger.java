package sofia.sap.interview.project.game.items.gear;

import sofia.sap.interview.project.game.items.ItemType;

import static sofia.sap.interview.project.game.items.ItemType.IRON_DAGGER;

public class IronDagger extends Dagger {

    private static final int EFFECT = 3;

    @Override
    public ItemType getType() {
        return IRON_DAGGER;
    }

    @Override
    public int getEffect() {
        return EFFECT;
    }
}
