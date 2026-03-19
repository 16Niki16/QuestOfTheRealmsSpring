package sofia.sap.interview.project.game.quests;

import java.util.function.Supplier;

public enum QuestType {
    FIND_IRON_KEY(FindIronKey::new),
    KILL_GOBLIN_KING(KillGoblinKing::new),
    KILL_BOSS(KillBoss::new),
    COLLECT_THREE_HERBS(CollectThreeHerbs::new);
    private final Supplier<Quest> quest;

    QuestType(Supplier<Quest> quest) {
        this.quest = quest;
    }

    public Quest create() {
        return quest.get();
    }
}
