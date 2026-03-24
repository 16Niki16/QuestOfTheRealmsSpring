package sofia.sap.interview.project.game.items.gear;

import sofia.sap.interview.project.game.items.ItemType;

public class GoldenSword extends Sword{
    private static final int EFFECT = 6;

    @Override
    public ItemType getType() {
        return ItemType.GOLDEN_SWORD;
    }

    @Override
    public int getEffect() {
        return EFFECT;
    }
}
