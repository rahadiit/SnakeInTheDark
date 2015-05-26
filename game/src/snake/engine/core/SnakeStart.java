package snake.engine.core;

import snake.engine.GameStart;
import snake.engine.creators.ScreenCreator;
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
			System.out.println("Cannot create Screen.");
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