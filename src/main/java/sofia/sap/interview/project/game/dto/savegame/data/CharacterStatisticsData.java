package sofia.sap.interview.project.game.dto.savegame.data;

import sofia.sap.interview.project.game.characters.attack.AttackRange;

public record CharacterStatisticsData(int health, int mana, AttackRange attackRange) {
}
