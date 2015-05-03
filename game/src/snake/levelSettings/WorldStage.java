package snake.levelSettings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.viewport.Viewport;

/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings
 */

public class WorldStage extends Stage {
	private Rectangle clipBounds, scissors; 
	//private OrthographicCamera
	
	public WorldStage() {
		super();
		createScissors();
	}
	public WorldStage(Viewport viewport) {
		super(viewport);
		createScissors();
	}
	public WorldStage(Viewport viewport, Batch batch) {
		super(viewport, batch);
		createScissors();
	}
	
	@Override
	public void draw() {
		
		Gdx.gl.glViewport(200, 200, 1000, 1000*Gdx.graphics.getHeight()/Gdx.graphics.getWidth());
		if (WorldSettings.hasVirtualScreen()) {
			ScissorStack.pushScissors(scissors);
		}
		super.draw();
		if (WorldSettings.hasVirtualScreen()) {
			ScissorStack.popScissors();
		}
		
		Gdx.gl.glViewport(0, 0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	public void createScissors() {
		scissors = new Rectangle();
		clipBounds = new Rectangle (WorldSettings.getVScreenX(), WorldSettings.getVScreenY(), 
				WorldSettings.getVScreenWidth(), WorldSettings.getVScreenHeight());
	
		ScissorStack.calculateScissors(this.getCamera(), this.getBatch().getTransformMatrix(), clipBounds, scissors);
	}
	
	public Rectangle getClipBounds () {
		return clipBounds;
	}
	
}
