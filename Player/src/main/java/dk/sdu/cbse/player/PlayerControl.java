package dk.sdu.cbse.player;

import dk.sdu.cbse.bullet.BulletSPI;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.GameEvents;
import dk.sdu.cbse.common.data.GameKeys;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

import java.util.Collection;


public class PlayerControl implements IPostEntityProcessingService {

    @Override
    public void process(GameData gameData, World world, GameEvents gameEvents) {
            
        for (Entity player : world.getEntities(Player.class)) {
            if (gameData.getKeys().isDown(GameKeys.LEFT)) {
                player.setRotation(player.getRotation() - 3);                
            }
            if (gameData.getKeys().isDown(GameKeys.RIGHT)) {
                player.setRotation(player.getRotation() + 3);                
            }
            if (gameData.getKeys().isDown(GameKeys.UP)) {
                double changeX = Math.cos(Math.toRadians(player.getRotation()));
                double changeY = Math.sin(Math.toRadians(player.getRotation()));
                player.setX(player.getX() + changeX);
                player.setY(player.getY() + changeY);
            }              
            if (player.getShootingCooldown() > 0) {
                player.setShootingCooldown(player.getShootingCooldown() - 1);
            } 
            else {    
                player.setShootingCooldown(20); 
            }
            
            if (player.getX() < 0) {
                player.setX(gameData.getDisplayWidth());
            }

            if (player.getX() > gameData.getDisplayWidth()) {
                player.setX(0);
            }

            if (player.getY() < 0) {
                player.setY(gameData.getDisplayHeight());
            }

            if (player.getY() > gameData.getDisplayHeight()) {
                player.setY(0);
            }                         
        }
    }
}