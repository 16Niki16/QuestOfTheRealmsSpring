package sofia.sap.interview.project.game.results.information;

import sofia.sap.interview.project.game.dto.events.QuestDTO;
import sofia.sap.interview.project.game.quests.Quest;
import sofia.sap.interview.project.game.quests.QuestLog;

import java.util.List;

import static sofia.sap.interview.project.game.results.information.ViewType.*;

public record QuestInformation(ViewType viewType, List<QuestDTO> active, List<QuestDTO> completed)
        implements ViewInformation {
    public static QuestInformation of(QuestLog questLog) {

        return new QuestInformation(QUESTS,
                transformToDTO(questLog.getActiveQuests()),
                transformToDTO(questLog.getCompletedQuests()));
    }

    private static List<QuestDTO> transformToDTO(List<Quest> quests) {
        return quests.stream()
                .map(QuestDTO::of)
                .toList();
    }
}
