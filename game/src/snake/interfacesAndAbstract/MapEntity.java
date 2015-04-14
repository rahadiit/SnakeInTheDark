package snake.interfacesAndAbstract;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;


/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings
 */


public abstract class MapEntity extends Group /* OR ACTOR? */ {
	int xInMap, yInMap;
	
	public int getMapPosX() { return xInMap; }
	public int getMapPosY() { return yInMap; }
	
	public void setMapPosX(int xInMap) { this.xInMap = xInMap; }
	public void setMapPosY(int yInMap) { this.yInMap = yInMap; }
	
	
	// Will be implemented
	public abstract void drawInMap(/* Map map */);
}
