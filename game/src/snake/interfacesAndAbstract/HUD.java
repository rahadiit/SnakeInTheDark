package snake.interfacesAndAbstract;

import snake.levelSettings.HUDSettings;
import com.badlogic.gdx.scenes.scene2d.Group;


/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings
 */


public abstract class HUD extends Group {

	public HUD(GameWorld world) {
		this.setBounds(0, 0, HUDSettings.getHudWidth(), HUDSettings.getHudHeight());
	}
	
	
	
	public abstract void dispose();
}
