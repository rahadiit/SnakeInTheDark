package snake.engine.creators;

import snake.engine.MainMenu;
import snake.engine.core.SnakeStart;
import snake.engine.gameScreens.SnakeHub;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * @author Mr.Strings (Modifiable according to need)
 * 
 * Create mainMenu as specified.
 * Controls Menu Parameters, etc.
 */

public class MainMenuSettings {
	
	
	public static MainMenu createMainMenu(SnakeStart game) {
		return new SnakeHub(game);
	}
}
