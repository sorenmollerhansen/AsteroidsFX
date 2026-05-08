package dk.sdu.cbse.asteroid;

import dk.sdu.cbse.asteroid.Asteroid;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.GameEvents;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessingService;

import java.util.Random;

public class AsteroidProcessor implements IEntityProcessingService {
    
    private final AsteroidSplitter splitter = new AsteroidSplitter();
    private final AsteroidFactory factory = new AsteroidFactory();

    @Override
    public void process(GameData gameData, World world, GameEvents gameEvents) {

        Entity[] entities = gameEvents.getCollisionEntities();
        
        if (entities[0] instanceof Asteroid && !(entities[1] instanceof Asteroid)) {                        
            
            world.removeEntity(entities[0]);
            splitter.splitAsteroid(entities[0], world);
            gameEvents.clearCollisionEntity0();
        } 

        else if (!(entities[0] instanceof Asteroid) && entities[1] instanceof Asteroid) {                        
        
            world.removeEntity(entities[1]);        
            splitter.splitAsteroid(entities[1], world);
            gameEvents.clearCollisionEntity1();
        } 
        
        int asteroidCount = world.getEntities(Asteroid.class).size(); 
        
        if (asteroidCount < 4) {
            factory.create(gameData);
        }
    }
}