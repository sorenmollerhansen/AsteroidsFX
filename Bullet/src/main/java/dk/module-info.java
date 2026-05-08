import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;

module Bullet {
    requires Common;

    exports dk.sdu.cbse.bullet;

    provides IEntityProcessingService with dk.sdu.cbse.bullet.BulletControl;
}
