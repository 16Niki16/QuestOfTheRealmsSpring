package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.characters.statistics.CharacterStatistics;
import sofia.sap.interview.project.game.dto.savegame.data.CharacterStatisticsData;

public class CharacterStatisticsDataFactory {
    public static CharacterStatisticsData create(CharacterStatistics statistics) {
        return new CharacterStatisticsData(statistics.getHealth(), statistics.getMana(),
            statistics.getAttackRange(), statistics.getManaCost());
    }
}
