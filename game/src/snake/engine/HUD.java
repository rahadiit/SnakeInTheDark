package snake.engine;

import snake.engine.creators.HUDSettings;
import com.badlogic.gdx.scenes.scene2d.Group;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 *  Generic game HUD -- information screens
 * @author Mr.Strings
 */


public abstract class HUD extends Group {

	public HUD(GameWorld world) {
		this.setBounds(0, 0, HUDSettings.getHudWidth(), HUDSettings.getHudHeight());
	}
	
	
	
	public abstract void dispose();
}