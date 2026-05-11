import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IEntityFactoryService;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

module Asteroid {
    requires Common;
    provides IEntityProcessingService with dk.sdu.cbse.asteroids.AsteroidProcessor;
    provides IEntityFactoryService with dk.sdu.cbse.asteroids.AsteroidFactory;
    provides IPostEntityProcessingService with dk.sdu.cbse.asteroids.AsteroidControl;
}