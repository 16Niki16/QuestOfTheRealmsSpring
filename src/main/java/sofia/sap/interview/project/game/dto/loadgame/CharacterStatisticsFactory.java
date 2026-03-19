package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.characters.statistics.CharacterStatistics;
import sofia.sap.interview.project.game.dto.savegame.data.CharacterStatisticsData;

public class CharacterStatisticsFactory {
    public static CharacterStatistics create(CharacterStatisticsData data) {
        return new CharacterStatistics(data.health(), data.attackRange(), data.mana());
    }
}
