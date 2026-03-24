package sofia.sap.interview.project.game.items.gear;

import sofia.sap.interview.project.game.items.ItemType;

public class IronDagger extends Dagger {

    private static final int EFFECT = 3;

    @Override
    public ItemType getType() {
        return ItemType.IRON_DAGGER;
    }

    @Override
    public int getEffect() {
        return EFFECT;
    }


}
