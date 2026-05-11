package dk.sdu.cbse.player;

import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.GameEvents;
import dk.sdu.cbse.common.services.IEntityFactoryService;


public class PlayerFactory implements IEntityFactoryService {

    @Override
    public Entity create(GameData gameData) {
        Entity player = new Player();

        player.setPolygonCoordinates(-5,-5,10,0,-5,5);

        player.setX(gameData.getDisplayHeight()/2);
        player.setY(gameData.getDisplayWidth()/2);

        player.setSize(8);

        return player;
    }
}