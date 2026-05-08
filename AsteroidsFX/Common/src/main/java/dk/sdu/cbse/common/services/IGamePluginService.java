package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IGamePluginService {

    void start(GameData gameData, World world);
        /*
        Preconditions:
            gameData and world needs to contain values to fire
            Plugins cannot be running

        Postconditions:
            Plugins are running
        */

    void stop(GameData gameData, World world);
        /*
        Preconditions:
            gameData and world needs to contain values to fire    
            Plugin is running

        Postconditions:
            All gameData and world is removed
            Plugin is no longer affecting the project/game
        */
}
