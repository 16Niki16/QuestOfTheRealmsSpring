package sofia.sap.interview.project.game.dto.data;

import java.util.List;

public record QuestsData(List<QuestData> active, List<QuestData> completed, int collectedXP) {
}
