package dk.sdu.cbse.player;

import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.GameEvents;
import dk.sdu.cbse.common.services.IEntityFactoryService;


public class PlayerFactory implements IEntityFactoryService {

    @Override
    public Entity create(GameData gameData) {
        Entity playerShip = new Player();

        playerShip.setPolygonCoordinates(-5,-5,10,0,-5,5);

        playerShip.setX(gameData.getDisplayHeight()/2);
        playerShip.setY(gameData.getDisplayWidth()/2);

        playerShip.setSize(8);

        return playerShip;
    }
}