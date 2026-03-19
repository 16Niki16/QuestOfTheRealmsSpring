package sofia.sap.interview.project.game.quests;

public enum Reward {
    SMALL(10),
    MEDIUM(25),
    BIG(50),
    GRAND(100);
    private final int rewardXP;

    Reward(int rewardXP) {
        this.rewardXP = rewardXP;
    }

    public int getRewardXP() {
        return rewardXP;
    }
}
