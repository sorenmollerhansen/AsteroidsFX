package dk.sdu.cbse.player;

import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.GameEvents;
import dk.sdu.cbse.common.services.IEntityProcessingService;

public class PlayerProcessor implements IEntityProcessingService{
    
    private final PlayerFactory factory = new PlayerFactory();

    @Override
    public void process(GameData gameData, World world, GameEvents gameEvents) {
        
        Entity[] entities = gameEvents.getCollisionEntities();
        if (entities[0] instanceof Player) {  
            
            world.removeEntity(entities[0]);
            gameEvents.clearCollisionEntity0();
            gameEvents.setPlayerHit(true);

            if (gameEvents.getPlayerAlive()) {
                factory.create(gameData);
            }
        }
        else if (entities[1] instanceof Player) {  
            
            world.removeEntity(entities[1]);
            gameEvents.clearCollisionEntity1();
            gameEvents.setPlayerHit(true);

            if (gameEvents.getPlayerAlive()) {
                factory.create(gameData);
            }
        }
    }
}