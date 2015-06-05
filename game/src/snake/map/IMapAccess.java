package snake.map;

import java.util.List;

public interface IMapAccess {

    List<IMapEntity> getEntities();
    void addEntity(IMapEntity entity);

}
