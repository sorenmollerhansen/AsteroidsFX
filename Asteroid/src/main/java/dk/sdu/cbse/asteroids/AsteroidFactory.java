package dk.sdu.cbse.asteroid;

import dk.sdu.cbse.common.services.IEntityFactoryService;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.Entity;

import java.util.Random;

public class AsteroidFactory implements IEntityFactoryService {
   
    @Override
    public Entity create(GameData gameData) {

        Random rnd = new Random();
        
        Asteroid asteroid = new Asteroid();

        int size = rnd.nextInt(20) + 5;
        asteroid.setPolygonCoordinates(size, -size, -size, -size, -size, size, size, size);
        asteroid.setSize(size);
        asteroid.setSpeed(size);

        int side = rnd.nextInt(4);
        switch (side) {
            case 0: //top
                asteroid.setX(rnd.nextInt(gameData.getDisplayWidth()));
                asteroid.setY(0);
                asteroid.setRotation(rnd.nextInt(10,80));
                break;
            case 1: //right side
                asteroid.setX(gameData.getDisplayWidth());
                asteroid.setY(rnd.nextInt(gameData.getDisplayHeight()));
                asteroid.setRotation(rnd.nextInt(100, 170));
                break;
            case 2: //bottom
                asteroid.setX(rnd.nextInt(gameData.getDisplayWidth()));
                asteroid.setY(gameData.getDisplayHeight());
                asteroid.setRotation(rnd.nextInt(190,260));
                break;
            case 3: //left side
                asteroid.setX(0);
                asteroid.setY(rnd.nextInt(gameData.getDisplayHeight()));
                asteroid.setRotation(rnd.nextInt(280,350));
                break;
        }
        return asteroid;
    }
}
