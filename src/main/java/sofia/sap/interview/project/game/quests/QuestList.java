package sofia.sap.interview.project.game.quests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class QuestList {
    private static final int MAX_QUESTS = 4;
    private static final int MIN_QUESTS = 1;
    private static final Map<QuestType, Supplier<Quest>> QUESTS = new EnumMap<>(QuestType.class);

    static {
        QUESTS.put(QuestType.FIND_IRON_KEY, FindIronKey::new);
        QUESTS.put(QuestType.KILL_GOBLIN_KING, KillGoblinKing::new);
        QUESTS.put(QuestType.KILL_BOSS, KillBoss::new);
        QUESTS.put(QuestType.COLLECT_THREE_HERBS, CollectThreeHerbs::new);

    }

    public static List<Quest> createQuests() {
        List<Supplier<Quest>> quests = new ArrayList<>(QUESTS.values());
        Collections.shuffle(quests);

        int numberOfQuests = ThreadLocalRandom.current().nextInt(MIN_QUESTS, MAX_QUESTS);

        return quests.stream()
                .limit(numberOfQuests)
                .map(Supplier::get)
                .collect(Collectors.toList());
    }
}
