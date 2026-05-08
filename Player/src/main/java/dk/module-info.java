import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IEntityFactoryService;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

module Player {
    requires Common;
    requires Bullet;
    
    provides IEntityProcessingService with dk.sdu.cbse.player.PlayerProcessor;
    provides IEntityFactoryService with dk.sdu.cbse.player.PlayerFactory;
    provides IPostEntityProcessingService with dk.sdu.cbse.player.PlayerControl;
}