package snake.map;

import java.util.Collection;
import java.util.List;

public interface IMapAccess {

    void loadNextMap();

    void reloadMap();

    List<IMapEntity> getEntities();

    List<IMapEntity> getEntities(int x, int y);

    List<IMapEntity> getEntities(int x, int y, String type);

    IMapEntity getEntity(int x, int y, String type);

    boolean addEntity(IMapEntity entity);

    boolean removeEntity(IMapEntity entity);

    int getMapWidth();

    int getMapHeight();

    int getTileWidth();

    int getTileHeight();

    CellType getCellType(int x, int y);

    void setCellType(int x, int y, CellType type);
}
