package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameEvents;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

public interface IEntityProcessingService {

    void process(GameData gameData, World world, GameEvents gameEvents);
        /*
        Preconditions:
            gameData and world contains values, so the method can fire
            Game/project is running
        
        Postconditions:
            Objects/entities have been created
            Game is still running
        */
}
