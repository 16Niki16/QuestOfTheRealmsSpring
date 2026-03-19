package sofia.sap.interview.project.game.dto.savegame.data;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public record EnemyData(EnemyType enemy, int health) {
}
