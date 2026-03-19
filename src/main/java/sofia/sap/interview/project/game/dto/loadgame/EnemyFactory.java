package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.characters.enemy.EnemyRegistry;
import sofia.sap.interview.project.game.dto.savegame.data.EnemyData;

public class EnemyFactory {
    public static Enemy create(EnemyData data) {
        Enemy enemy = EnemyRegistry.create(data.enemy());
        enemy.load(data.health());

        return enemy;
    }
}
