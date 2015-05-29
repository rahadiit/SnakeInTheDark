package snake.start;

import snake.engine.creators.ScreenCreator;
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
		String[] param = {"SnakeScreen", "SnakeHub", "levelDataID"}; 
		
		try {
			ScreenCreator.addAndGo(param);
		} catch (Exception e) {
			e.printStackTrace(System.out);
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
	}
}