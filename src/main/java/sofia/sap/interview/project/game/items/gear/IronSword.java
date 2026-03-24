package sofia.sap.interview.project.game.items.gear;

import sofia.sap.interview.project.game.items.ItemType;

public class IronSword extends Sword {
    private static final int EFFECT = 4;

    @Override
    public ItemType getType() {
        return ItemType.IRON_SWORD;
    }

    @Override
    public int getEffect() {
        return EFFECT;
    }
}
