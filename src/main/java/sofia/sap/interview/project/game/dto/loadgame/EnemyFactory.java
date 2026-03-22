package sofia.sap.interview.project.game.dto.loadgame;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.dto.savegame.data.EnemyData;

public class EnemyFactory {
    public static Enemy create(EnemyData data) {
        Enemy enemy = sofia.sap.interview.project.game.characters.enemy.EnemyFactory.create(data.enemy());
        enemy.load(data.health());

        return enemy;
    }
}
