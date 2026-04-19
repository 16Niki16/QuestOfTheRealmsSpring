package sofia.sap.interview.project.game.items.gear;

import static sofia.sap.interview.project.game.items.gear.GearType.DAGGER;

public abstract class Dagger extends GearBase {

    @Override
    public GearType getGearType() {
        return DAGGER;
    }
}
