package sofia.sap.interview.project.game.quests;

import sofia.sap.interview.project.game.events.GameEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class QuestLog {
    private final List<Quest> activeQuests;
    private final List<Quest> completedQuests;
    private int collectedXP;

    public QuestLog() {
        this.activeQuests = QuestList.createQuests();
        this.completedQuests = new ArrayList<>();
        this.collectedXP = 0;
    }

    private QuestLog(List<Quest> active, List<Quest> completed, int collectedXP) {
        this.activeQuests = active;
        this.completedQuests = completed;
        this.collectedXP = collectedXP;
    }

    public static QuestLog load(List<Quest> active, List<Quest> completed, int collectedXP) {
        return new QuestLog(active, completed, collectedXP);
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

    public int getCollectedXP() {
        return this.collectedXP;
    }
}
