package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.dto.data.EnemyData;

import static sofia.sap.interview.project.game.characters.enemy.EnemyRegistry.createEnemy;

public class EnemyFactory {
    public static Enemy create(EnemyData data) {
        Enemy enemy = createEnemy(data.enemy());
        enemy.load(data.health());

        return enemy;
    }
}
