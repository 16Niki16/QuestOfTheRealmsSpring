package sofia.sap.interview.project.game.items.gear;

import static sofia.sap.interview.project.game.items.gear.GearType.SWORD;

public abstract class Sword extends GearBase {
    @Override
    public GearType getGearType() {
        return SWORD;
    }
}
