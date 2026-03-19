package sofia.sap.interview.project.game.dto.savegame.data;

import java.util.List;
public record QuestsData(List<QuestData> active, List<QuestData> completed, int collectedXP) {
}
