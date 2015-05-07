package snake.engine.InterfaceAbstract;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *          
 *  <br> Interface for a starting point (core) of a Game. Should ideally extend com.badlogic.gdx.Game; </br>
 *  <br> See snake.core.SnakeStart for a good implementation of interface
 * @Author Mr.Strings
 */

public interface GameStart {
	
	public SpriteBatch getBatch();
	public void setScreen (Screen screen);
}
