package snake.visuals.enhanced;

import snake.map.IMapEntity;

public interface ILightMapEntity extends IMapEntity {
    boolean hasLights();

    void createLights();
}
