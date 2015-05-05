package snake.interfacesAndAbstract;

import snake.core.SnakeStart;
import snake.levelSettings.WorldStage;
import com.badlogic.gdx.scenes.scene2d.Actor;


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
	protected SnakeStart game;
	protected int xInMap, yInMap;
	
	public MapEntity (SnakeStart game, GameWorld world) {
		this.game = game;
		world.addActor(this);
	}
	
	
	/* ------------- Getters -------------- */
	public int getMapPosX() { return xInMap; }
	public int getMapPosY() { return yInMap; }
	
	public WorldStage getStage() {
		if (super.getStage() instanceof WorldStage)
			return (WorldStage) super.getStage();
		else
			throw new UnsupportedOperationException("MapEntity has to be in a WorldStage.");
	}
	
	
	/* ------------- Setters -------------- */
	public void setMapPosition (int xInMap, int yInMap) {
		this.setPosition(xInMap, yInMap);
		this.xInMap = xInMap;
		this.yInMap = yInMap;
	}
	
	
	
}
