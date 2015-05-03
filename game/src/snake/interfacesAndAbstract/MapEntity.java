package snake.interfacesAndAbstract;

import snake.core.SnakeStart;
import com.badlogic.gdx.scenes.scene2d.Actor;


/**                              Developed By:
 *                                  NoDark
 *                               sessaGlasses
 *                               
 * Entity that belongs to a GameWorld             
 * 
 * @actor Mr.Strings
 * 
 */


public abstract class MapEntity extends Actor {
	protected SnakeStart game;
	protected int xInMap, yInMap;
	
	public MapEntity (SnakeStart game, GameWorld world) {
		this.game = game;
		world.addActor(this);
	}
	
	public int getMapPosX() { return xInMap; }
	public int getMapPosY() { return yInMap; }
	
	public void setMapPosition (int xInMap, int yInMap) {
		this.setPosition(xInMap, yInMap);
		this.xInMap = xInMap;
		this.yInMap = yInMap;
	}
}
