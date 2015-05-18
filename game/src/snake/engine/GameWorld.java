package snake.engine;

import com.badlogic.gdx.scenes.scene2d.Group;
import snake.engine.creators.WorldSettings;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 * <br> Class for a World of the game -- Can be anything such as 2D sidescroller or top-down, or even fully 3D game (although
 * the focus is on 2D) </br>
 * Module: Mr.Strings
 */


public abstract class GameWorld extends Group /* Group makes it connected to MapEntities */ {
	
	public GameWorld () {
		this.setSize(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight()); //Sets world size to be displayed on screen
	}
	
	public abstract void dispose();
	
	
}
