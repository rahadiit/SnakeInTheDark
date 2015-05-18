package snake.engine.gameScreens;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 *  Extension of stage -- gives easy access to level and, consequently, elements in it
 *  @author Mr.Strings
 */


public class LevelStage extends Stage{
	private SnakeLevel level;
	
	public LevelStage(SnakeLevel level) {
		super();
		this.level = level;
	}
	
	public LevelStage(SnakeLevel level, Viewport viewport) {
		super(viewport);
		this.level = level;
	}
	
	public LevelStage(SnakeLevel level, Viewport viewport, Batch batch) {
		super(viewport, batch);
		this.level = level;
	}
	
	/* ---------------- Getters --------------- */
	public SnakeLevel getLevel() {
		return level;
	}	
}
