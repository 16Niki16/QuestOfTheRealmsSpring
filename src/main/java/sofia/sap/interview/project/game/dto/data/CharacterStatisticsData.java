package sofia.sap.interview.project.game.dto.data;

import sofia.sap.interview.project.game.characters.statistics.attack.AttackRange;

public record CharacterStatisticsData(int health, int mana, AttackRange attackRange, int manaCost) {
}
