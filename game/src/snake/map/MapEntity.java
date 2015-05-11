package snake.map;

import snake.engine.GameWorld;
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


public interface MapEntity {
	
	
	/*protected SnakeStart game;
	protected int xInMap, yInMap;*/
	
	/*public MapEntity (SnakeStart game, GameWorld world) {
		this.game = game;
		world.addActor(this);
	}*/
	
	
	/** Adds MapEntity to World. Easy way to do it is extending from Actor
	 * or Group
	 * @param world -- World in Which mapEntity will be added.
	 */
	public void addToWorld (GameWorld world);
	
	/* ------------- Getters -------------- */
	public int getMapPosX();
	public int getMapPosY();
	
	public Stage getStage();
	public GameWorld getWorld();
	
	/* ------------- Setters -------------- */
	public void setMapPosition (int xInMap, int yInMap);
	
}
