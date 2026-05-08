import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IEntityFactoryService;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

module Asteroid {
    requires Common;
    provides IEntityProcessingService with dk.sdu.cbse.asteroid.AsteroidProcessor;
    provides IEntityFactoryService with dk.sdu.cbse.asteroid.AsteroidFactory;
    provides IPostEntityProcessingService with dk.sdu.cbse.asteroid.AsteroidControl;
}