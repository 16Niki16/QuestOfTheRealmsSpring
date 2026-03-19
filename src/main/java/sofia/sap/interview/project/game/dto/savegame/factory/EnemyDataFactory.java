package sofia.sap.interview.project.game.dto.savegame.factory;

import sofia.sap.interview.project.game.characters.enemy.Enemy;
import sofia.sap.interview.project.game.dto.savegame.data.EnemyData;

public class EnemyDataFactory {
    public static EnemyData create(Enemy enemy) {
        return new EnemyData(enemy.getType(), enemy.health());
    }
}
