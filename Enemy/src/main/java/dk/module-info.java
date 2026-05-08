import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IEntityFactoryService;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

module Enemy {
    requires Common;
    requires Bullet;
    
    provides IEntityProcessingService with dk.sdu.cbse.enemy.EnemyProcessor;
    provides IEntityFactoryService with dk.sdu.cbse.enemy.EnemyFactory;
    provides IPostEntityProcessingService with dk.sdu.cbse.enemy.EnemyControl;
}