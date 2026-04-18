package sofia.sap.interview.project.game.quests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sofia.sap.interview.project.game.results.events.GameEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static sofia.sap.interview.project.game.quests.QuestRegistry.*;

@AllArgsConstructor
public class QuestLog {
    private final List<Quest> activeQuests;
    private final List<Quest> completedQuests;
    @Getter
    private int collectedXP;

    public static QuestLog createNewQuestLog() {
        List<Quest> activeQuests = createQuests();

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

    public boolean areAllQuestsCompleted() {
        return this.activeQuests.isEmpty();
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
