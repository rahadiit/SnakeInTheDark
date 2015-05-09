package snake.engine.core;

import snake.engine.GameStart;
import snake.engine.creators.MainMenuSettings;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * @Author Mr.Strings
 */

public class SnakeStart extends Game implements GameStart {
	public SpriteBatch batch;
	
	
	public SpriteBatch getBatch () {return batch;}

	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(MainMenuSettings.createMainMenu(this));
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