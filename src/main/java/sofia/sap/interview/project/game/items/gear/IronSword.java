package sofia.sap.interview.project.game.items.gear;

import sofia.sap.interview.project.game.items.ItemType;

import static sofia.sap.interview.project.game.items.ItemType.IRON_SWORD;

public class IronSword extends Sword {
    private static final int EFFECT = 4;

    @Override
    public ItemType getType() {
        return IRON_SWORD;
    }

    @Override
    public int getEffect() {
        return EFFECT;
    }
}
