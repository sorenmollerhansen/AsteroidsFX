package dk.sdu.cbse.enemy;

import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.GameEvents;
import dk.sdu.cbse.common.services.IEntityFactoryService;


import java.util.Random;

public class EnemyFactory implements IEntityFactoryService {

    @Override
    public Entity create(GameData gameData) {
        Random rnd = new Random();
        
        Enemy enemyShip = new Enemy();
        enemyShip.setPolygonCoordinates(-5,-5,10,0,-5,5);
        enemyShip.setSize(8);

        int side = rnd.nextInt(4);
        switch (side) {
            case 0: //top
                enemyShip.setX(rnd.nextInt(gameData.getDisplayWidth()));
                enemyShip.setY(0);
                break;
            case 1: //right side
                enemyShip.setX(gameData.getDisplayWidth());
                enemyShip.setY(rnd.nextInt(gameData.getDisplayHeight()));
                break;
            case 2: //bottom
                enemyShip.setX(rnd.nextInt(gameData.getDisplayWidth()));
                enemyShip.setY(gameData.getDisplayHeight());
                break;
            case 3: //left side
                enemyShip.setX(0);
                enemyShip.setY(rnd.nextInt(gameData.getDisplayHeight()));
                break;
        }

        return enemyShip;
    }
}