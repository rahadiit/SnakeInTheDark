package snake.engine;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * @author Mr.Strings
 */

public interface Cutscene {
	
	public void draw();
	public void act(float delta);

	public void begin(String name);
	
	public boolean isRunning();
	
	public void setBatch (SpriteBatch batch);
}
