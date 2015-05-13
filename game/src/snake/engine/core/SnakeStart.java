package snake.engine.core;

import snake.engine.GameStart;
import snake.engine.settings.ScreenSettings;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * @Author Mr.Strings
 */

public class SnakeStart extends GameStart {
	

	public void create () {
		super.batch = new SpriteBatch();
		ScreenSettings.setGameInstance(this);
		ScreenSettings.goToScreen("SnakeHub", "Nope...", "These two are actually not important");
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}