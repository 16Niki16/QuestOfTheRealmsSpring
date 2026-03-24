package sofia.sap.interview.project.game.quests;

import lombok.Getter;
import sofia.sap.interview.project.game.events.GameEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class QuestLog {
    private final List<Quest> activeQuests;
    private final List<Quest> completedQuests;
    @Getter
    private int collectedXP;

    public QuestLog(List<Quest> active, List<Quest> completed, int collectedXP) {
        this.activeQuests = active;
        this.completedQuests = completed;
        this.collectedXP = collectedXP;
    }

    public static QuestLog createNewQuestLog() {
        List<Quest> activeQuests = QuestRegistry.createQuests();
        return new QuestLog(activeQuests, new ArrayList<>(), 0);
    }

    public List<Quest> getActiveQuests() {
        return Collections.unmodifiableList(activeQuests);
    }

    public List<Quest> getCompletedQuests() {
        return Collections.unmodifiableList(completedQuests);
    }

    public Quest getLastCompletedQuest() {
        return this.completedQuests.getLast();
    }

    public boolean handleEvent(GameEvent event) {
        Iterator<Quest> it = activeQuests.iterator();
        while (it.hasNext()) {
            Quest quest = it.next();
            quest.update(event);

            if (quest.isCompleted()) {
                it.remove();
                completedQuests.add(quest);
                collectedXP += quest.getReward().getRewardXP();
                return true;
            }
        }
        return false;
    }

}
