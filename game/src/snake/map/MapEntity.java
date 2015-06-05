package snake.map;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import snake.engine.core.LevelStage;
import snake.engine.models.GameWorld;

/**                              Developed By:
 *                               NoDarkGlasses
 *
 * <br />
 * Entity that belongs in a GameWorld
 *
 * @author Mr.Strings
 */
public abstract class MapEntity extends Group implements IMapEntity {

    protected int xInMap, yInMap;
    public GameWorld world;

    //Creates and adds actor to world
    public MapEntity(GameWorld world) {
        this.world = world;
    }

    public MapEntity() {
    }

    @Override
    public LevelStage getStage() {
        return (LevelStage) super.getStage();
    }

    @Override
    public void dispose() {
        for (Actor child : getChildren()) {
            if (child instanceof MapEntity)
                ((MapEntity) child).dispose();
        }
    }
}
