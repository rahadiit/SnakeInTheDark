package snake.hud;

import snake.interfacesAndAbstract.GameWorld;
import snake.interfacesAndAbstract.HUD;

/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings
 */


public class SnakeHUD extends HUD {
	GameWorld world;
	SnakeInfosHUD infos;
	SnakeDialogHUD dialog;
	
	public SnakeHUD (GameWorld world) {
		this.world = world;
		infos = new SnakeInfosHUD(world);
		dialog  = new SnakeDialogHUD(world);
	}
}
