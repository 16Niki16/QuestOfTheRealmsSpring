package sofia.sap.interview.project.game.dto.newgame.mappers;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.EnemyRegistry;
import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;

public class EnemyMapper {
    public static Enemy map(EnemyType enemy) {
        if (enemy == null) {
            return null;
        }

        return EnemyRegistry.create(enemy);
    }
}
