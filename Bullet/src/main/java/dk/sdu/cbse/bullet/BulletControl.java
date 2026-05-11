package dk.sdu.cbse.bullet;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.GameEvents;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IEntityProcessingService;

public class BulletControl implements IEntityProcessingService, BulletSPI {

    @Override
    public void process(GameData gameData, World world, GameEvents gameEvents) {
        
        Entity[] entities = gameEvents.getCollisionEntities();
        if (entities[0] instanceof Bullet) {
            world.removeEntity(entities[0]);
            gameEvents.clearCollisionEntity0();
        }
        else if (entities[1] instanceof Bullet) {
            world.removeEntity(entities[1]);
            gameEvents.clearCollisionEntity1();
        }

        for (Entity bullet : world.getEntities(Bullet.class)) {
            double changeX = Math.cos(Math.toRadians(bullet.getRotation()));
            double changeY = Math.sin(Math.toRadians(bullet.getRotation()));
            bullet.setX(bullet.getX() + changeX * 3);
            bullet.setY(bullet.getY() + changeY * 3);

            //remove bullets when they hit the border, to make sure they don't live outside the window
            if (bullet.getX() < 0) {
                world.removeEntity(bullet);
            }

            if (bullet.getX() > gameData.getDisplayWidth()) {
                world.removeEntity(bullet);
            }

            if (bullet.getY() < 0) {
                world.removeEntity(bullet);
            }

            if (bullet.getY() > gameData.getDisplayHeight()) {
                world.removeEntity(bullet);
            }
        } 
    }

    @Override
    public Entity create(Entity shooter, GameData gameData) {
        
        Entity bullet = new Bullet();

        bullet.setPolygonCoordinates(5, -1, 1, 1, -1, 1, -1, -1);

        double changeX = Math.cos(Math.toRadians(shooter.getRotation()));
        double changeY = Math.sin(Math.toRadians(shooter.getRotation()));

        bullet.setX(shooter.getX() + changeX * 10);
        bullet.setY(shooter.getY() + changeY * 10);

        bullet.setRotation(shooter.getRotation());
        bullet.setSize(1);

        return bullet;
    }
}