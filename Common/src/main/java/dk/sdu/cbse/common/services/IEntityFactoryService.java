package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;

public interface IEntityFactoryService {
    Entity create(GameData gameData);
}
