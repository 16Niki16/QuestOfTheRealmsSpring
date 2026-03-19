package sofia.sap.interview.project.game.characters.enemy;

import sofia.sap.interview.project.game.characters.enemy.type.EnemyType;
import sofia.sap.interview.project.game.exceptions.EnemyTypeNotAvailableException;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class EnemyRegistry {
    private static final Map<EnemyType, Supplier<Enemy>> ENEMIES = new EnumMap<>(EnemyType.class);

    static {
        ENEMIES.put(EnemyType.GOBLIN, Goblin::new);
        ENEMIES.put(EnemyType.BOSS, Boss::new);
        ENEMIES.put(EnemyType.BANDIT, Bandit::new);
        ENEMIES.put(EnemyType.GOBLIN_KING, GoblinKing::new);
    }

    public static Enemy create(EnemyType type) {
        Supplier<Enemy> sup = ENEMIES.get(type);

        if (sup == null) {
            throw new EnemyTypeNotAvailableException("The provided enemy is not in the list!");
        }
        return sup.get();
    }
}
