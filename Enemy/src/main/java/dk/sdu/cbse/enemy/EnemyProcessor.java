package dk.sdu.cbse.enemy;

import dk.sdu.cbse.enemy.Enemy;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.GameEvents;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessingService;

import java.util.Random;

public class EnemyProcessor implements IEntityProcessingService {
    
    private final EnemyFactory factory = new EnemyFactory();

    @Override
    public void process(GameData gameData, World world, GameEvents gameEvents) {

        Entity[] entities = gameEvents.getCollisionEntities();        
        
        if (entities[0] instanceof Enemy) {
            world.removeEntity(entities[0]);
            gameEvents.clearCollisionEntity0();
        }
        else if (entities[1] instanceof Enemy) {
            world.removeEntity(entities[1]);
            gameEvents.clearCollisionEntity1();
        }

        int enemyCount = world.getEntities(Enemy.class).size(); 
        
        if (enemyCount < 2) {
            factory.create(gameData);
        }

    }
}

