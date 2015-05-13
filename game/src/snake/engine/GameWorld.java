package snake.engine;

import com.badlogic.gdx.scenes.scene2d.Group;
import snake.engine.creators.WorldSettings;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * Module: Mr.Strings
 */


public abstract class GameWorld extends Group /* Group makes it connected to MapEntities */ {
	
	public GameWorld () {
		this.setSize(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight());
	}
	
	public abstract void dispose();
	
	
}
