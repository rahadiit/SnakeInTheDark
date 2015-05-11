package snake.map;

import snake.engine.GameStart;
import snake.engine.GameWorld;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;


/**                              Developed By:
 *                                  NoDark
 *                               sessaGlasses
 *                               
 * Entity that belongs to a GameWorld             
 * 
 * @author Mr.Strings
 * 
 */


public abstract class MapEntity extends Actor {
	
	protected int xInMap, yInMap;
	
	public MapEntity (GameWorld world) {
		world.addActor(this);
	}
	
	
	/** removes MapEntity from World.
	 * @param world -- World in Which mapEntity will be added.
	 */
	
	/* ------------- Getters -------------- */
	public abstract int getMapPosX();
	public abstract int getMapPosY();
	
	public abstract Stage getStage();
	
	/* ------------- Setters -------------- */
	public abstract void setMapPosition (int xInMap, int yInMap);
	
}
