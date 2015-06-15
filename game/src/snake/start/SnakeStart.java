package snake.start;

import snake.engine.creators.ScreenCreator;
import snake.engine.dataManagment.Loader;
import snake.engine.models.GameStart;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * @Author Mr.Strings
 */

public class SnakeStart extends GameStart {
	

	public void create () {
		super.batch = new SpriteBatch();
		ScreenCreator.setGameInstance(this);
		
		try {
			ScreenCreator.addAndGo("SnakeScreen", "snakeHub", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ScreenCreator.updateScreens();
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		Loader.getManager().clear();
	}
}