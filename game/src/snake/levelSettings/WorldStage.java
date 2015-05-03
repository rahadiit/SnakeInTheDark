package snake.levelSettings;

import snake.gameScreens.SnakeLevel;
import snake.imageUtilities.CameraMan;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
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
	private SnakeLevel level;
	private Rectangle clipBounds, scissors;
	private CameraMan cameraMan;
	
	public WorldStage(SnakeLevel level) {
		super();
		this.level = level;
		cameraMan = new CameraMan (this);
	}
	public WorldStage(SnakeLevel level, Viewport viewport) {
		super(viewport);
		this.level = level;
		cameraMan = new CameraMan (this);
	}
	public WorldStage(SnakeLevel level, Viewport viewport, Batch batch) {
		super(viewport, batch);
		this.level = level;
		cameraMan = new CameraMan (this);
	}
	
	
	@Override
	public void act (float delta) {
		getInput(delta);
		super.act(delta);
	}
	
	@Override
	public void draw() {
		
		cameraMan.setCamera();
		super.draw();
		cameraMan.unsetCamera();
	}
	
	
	private void getInput (float delta) {
		
		
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
			cameraMan.moveCamera(this.getBatch(), -20f * delta, 0);
		
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			cameraMan.moveCamera(this.getBatch(), 20f * delta, 0);
		
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
			cameraMan.moveCamera(this.getBatch(), 0, -20f * delta);
		
		if (Gdx.input.isKeyPressed(Input.Keys.UP))
			cameraMan.moveCamera(this.getBatch(), 0, 20f * delta);
		
		if (Gdx.input.isKeyPressed(Input.Keys.O))
			cameraMan.zoomCamera(-.5f * delta);
		
		if (Gdx.input.isKeyPressed(Input.Keys.P))
			cameraMan.zoomCamera(.5f * delta);
	}
	
	
	
	
	
	/* ---------------- Getters --------------- */
	public SnakeLevel getLevel() {
		return level;
	}
	
}
