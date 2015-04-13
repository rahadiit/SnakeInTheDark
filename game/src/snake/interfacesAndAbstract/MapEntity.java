package snake.interfacesAndAbstract;


/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings
 */


public abstract class MapEntity implements Drawable {
	int xInMap, yInMap;
	
	public int getMapPosX() { return xInMap; }
	public int getMapPosY() { return yInMap; }
	
	public void setMapPosX(int xInMap) { this.xInMap = xInMap; }
	public void setMapPosY(int yInMap) { this.yInMap = yInMap; }
	
	
	// Will be implemented
	public abstract void drawInMap(/* Map map */);
}
