package dk.sdu.cbse.asteroid;

import dk.sdu.cbse.asteroid.Asteroid;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.GameEvents;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

public class AsteroidControl implements IPostEntityProcessingService {

    @Override
    public void process(GameData gameData, World world, GameEvents gameEvents) {

        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
            double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));

            Asteroid a = (Asteroid) asteroid;

            asteroid.setX(asteroid.getX() + changeX * a.getSpeed()); // speed is size-based
            asteroid.setY(asteroid.getY() + changeY * a.getSpeed());

            if (asteroid.getX() < 0) {
                asteroid.setX(gameData.getDisplayWidth());
            }

            if (asteroid.getX() > gameData.getDisplayWidth()) {
                asteroid.setX(0);
            }

            if (asteroid.getY() < 0) {
                asteroid.setY(gameData.getDisplayHeight());
            }

            if (asteroid.getY() > gameData.getDisplayHeight()) {
                asteroid.setY(0);
            } 

        }

    }

}