package snake.map;

import java.util.List;

public interface IMapAccess {

    List<IMapEntity> getEntities();

    IMapEntity getEntity(int x, int y);

    boolean addEntity(IMapEntity entity);

    boolean removeEntity(IMapEntity entity);

    int getMapWidth();

    int getMapHeight();

    int getTileWidth();

    int getTileHeight();

    CellType getCellType(int x, int y);

    void setCellType(int x, int y, CellType type);
}
