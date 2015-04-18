package snake.interfacesAndAbstract;

import snake.core.SnakeStart;
import snake.levelSettings.WorldSettings;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Group;

/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings && --------- (modifiable according to need)
 */


public abstract class GameWorld extends Group /* Group make it connected to MapEntities */ {
	protected SnakeStart game;
	
	public GameWorld (SnakeStart game) {
		this.game = game;
		this.setSize(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight());
	}
}
