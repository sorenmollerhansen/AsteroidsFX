package dk.sdu.cbse.enemy;

import dk.sdu.cbse.bullet.BulletSPI;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.GameEvents;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

import java.util.Random;

public class EnemyControl implements IPostEntityProcessingService {

    @Override
    public void process(GameData gameData, World world, GameEvents gameEvents) {
        
        for (Entity enemy : world.getEntities(Enemy.class)) {
            Random rnd = new Random();
            int mvmnt = rnd.nextInt(10)+1;
            switch (mvmnt % 2){
                case 0:
                    double changeX = Math.cos(Math.toRadians(enemy.getRotation()));
                    double changeY = Math.sin(Math.toRadians(enemy.getRotation()));
                    enemy.setX(enemy.getX() + changeX);
                    enemy.setY(enemy.getY() + changeY);
                    break;
                
                case 1: break;
            }

            switch (mvmnt % 3){
                case 0:
                    enemy.setRotation(enemy.getRotation() - 4);
                    break;
                
                case 1: 
                    enemy.setRotation(enemy.getRotation() + 4);
                    break;

                case 2: break;
            }

            if (enemy.getShootingCooldown() > 0) {
                enemy.setShootingCooldown(enemy.getShootingCooldown() - 1);
            } 
            else {
            
                enemy.setShootingCooldown(20); 
            }
            
            if (enemy.getX() < 0) {
                enemy.setX(gameData.getDisplayWidth());
            }

            if (enemy.getX() > gameData.getDisplayWidth()) {
                enemy.setX(0);
            }

            if (enemy.getY() < 0) {
                enemy.setY(gameData.getDisplayHeight());
            }

            if (enemy.getY() > gameData.getDisplayHeight()) {
                enemy.setY(0);
            }                         
        }
    }

    
}