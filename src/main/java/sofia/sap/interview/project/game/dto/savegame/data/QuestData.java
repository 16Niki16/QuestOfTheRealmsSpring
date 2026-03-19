package sofia.sap.interview.project.game.dto.savegame.data;

import sofia.sap.interview.project.game.quests.QuestType;

public record QuestData(QuestType type, boolean completed, Integer progress) {
}
