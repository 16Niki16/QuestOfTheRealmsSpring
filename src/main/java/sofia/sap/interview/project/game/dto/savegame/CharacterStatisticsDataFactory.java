package sofia.sap.interview.project.game.dto.savegame;

import sofia.sap.interview.project.game.characters.statistics.CharacterStatistics;
import sofia.sap.interview.project.game.dto.data.CharacterStatisticsData;

public class CharacterStatisticsDataFactory {
    public static CharacterStatisticsData create(CharacterStatistics statistics) {
        return new CharacterStatisticsData(statistics.getHealth(), statistics.getMana(),
            statistics.getAttackRange(), statistics.getManaCost());
    }
}
