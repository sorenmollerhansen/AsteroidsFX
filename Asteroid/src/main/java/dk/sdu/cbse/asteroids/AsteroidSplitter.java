package dk.sdu.cbse.asteroids;

import dk.sdu.cbse.asteroids.Asteroid;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.World;

import java.util.Random;

public class AsteroidSplitter {

    public void splitAsteroid(Entity e, World world) {
        float size = e.getSize();

        if (size <= 5) {
            return;
        }

        Random rnd = new Random();
        float newSize = size/2;
        double rotation = e.getRotation();

        Asteroid newAsteroid1 = new Asteroid();
        Asteroid newAsteroid2 = new Asteroid();

        newAsteroid1.setPolygonCoordinates(newSize, -newSize, -newSize, -newSize, -newSize, newSize, newSize, newSize);
        newAsteroid1.setSize(newSize);
        newAsteroid1.setX(e.getX()+size);
        newAsteroid1.setY(e.getY()+size);
        newAsteroid1.setRotation(rotation + rnd.nextDouble(10,20));
        newAsteroid1.setSpeed(newSize);

        newAsteroid2.setPolygonCoordinates(newSize, -newSize, -newSize, -newSize, -newSize, newSize, newSize, newSize);
        newAsteroid2.setSize(newSize);
        newAsteroid2.setX(e.getX()+rnd.nextInt(10));
        newAsteroid2.setY(e.getY()+rnd.nextInt(10));
        newAsteroid2.setRotation(rotation - rnd.nextDouble(10, 20));
        newAsteroid2.setSpeed(newSize);

        world.addEntity(newAsteroid1);
        world.addEntity(newAsteroid2);
    }   
}