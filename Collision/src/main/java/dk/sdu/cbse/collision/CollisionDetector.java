package dk.sdu.cbse.collision;

import dk.sdu.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.GameEvents;
import dk.sdu.cbse.common.data.World;

public class CollisionDetector implements IPostEntityProcessingService {

    @Override
    public void process(GameData gameData, World world, GameEvents gameEvents) {

        for (Entity entity1 : world.getEntities()) {
            for (Entity entity2 : world.getEntities()) {

                if (entity1.getID().equals(entity2.getID()) || entity1.getClass() == entity2.getClass()) {
                    continue;                    
                }

                if (this.collides(entity1, entity2)) {
                    gameEvents.setCollisionEntities(entity1, entity2);
                }
            }
        }
    }

    public Boolean collides(Entity entity1, Entity entity2) {
       
        float dx = (float) entity1.getX() - (float) entity2.getX();
        float dy = (float) entity1.getY() - (float) entity2.getY();
       
        float distance = (float) Math.sqrt(dx * dx + dy * dy);

        return distance < (entity1.getSize() + entity2.getSize());
    }
}