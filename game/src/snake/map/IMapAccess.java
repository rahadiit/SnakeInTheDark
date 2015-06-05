package snake.map;

import java.util.List;

public interface IMapAccess {

    List<MapEntity> getEntities();
    void addEntity(MapEntity entity);

}
