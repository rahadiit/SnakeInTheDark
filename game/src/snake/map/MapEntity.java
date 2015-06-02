package snake.map;

import snake.engine.core.LevelStage;
import snake.engine.models.GameWorld;
import com.badlogic.gdx.scenes.scene2d.Group;

/**                              Developed By:
 *                                  NoDark
 *                               sessaGlasses
 *                               
 * Entity that belongs to a GameWorld             
 * 
 * @author Mr.Strings
 * 
 */


public abstract class MapEntity extends Group {
	
	protected int xInMap, yInMap;
	
	
	//Creates and adds actor to world
	public MapEntity (GameWorld world) {
		world.addActor(this);
	}
	
	public MapEntity () {}
	
	//Adds actor to a custom group
	public MapEntity (Group group) {
		group.addActor(this);
	}
	
	@Override
	public LevelStage getStage() {
		return (LevelStage) super.getStage();
	}
}
