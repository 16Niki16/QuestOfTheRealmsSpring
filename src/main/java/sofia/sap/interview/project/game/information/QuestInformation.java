package sofia.sap.interview.project.game.information;

import sofia.sap.interview.project.game.quests.Quest;

import java.util.List;

public record QuestInformation(List<Quest> active, List<Quest> completed) implements ViewInformation {
}
