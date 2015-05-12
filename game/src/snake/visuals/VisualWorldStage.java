package snake.visuals;

import snake.engine.gameScreens.WorldStage;
import snake.engine.gameScreens.SnakeLevel;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * 
 * Convenient extension of Stage for camera Handling
 * 
 * @author Mr.Strings
 */

public class VisualWorldStage extends WorldStage {
	private CameraMan cameraMan;
	
	public VisualWorldStage(SnakeLevel level) {
		super(level);
		cameraMan = new CameraMan(this);
		cameraMan.addLightSupport(1);
		
		try {
			VisualGameWorld world = (VisualGameWorld) level.getGameWorld();
			world.createLights();
		} catch (Exception e) {
			System.out.println ("GameWorld of VisualWorldStage must be a VisualGameWorld");
		}
	}
	public VisualWorldStage(SnakeLevel level, Viewport viewport) {
		super(level, viewport);
		cameraMan = new CameraMan (this);
		cameraMan.addLightSupport(1);
		try {
			VisualGameWorld world = (VisualGameWorld) level.getGameWorld();
			world.createLights();
		} catch (Exception e) {
			System.out.println ("GameWorld of VisualWorldStage must be a VisualGameWorld");
		}
	}
	public VisualWorldStage(SnakeLevel level, Viewport viewport, Batch batch) {
		super(level, viewport, batch);
		cameraMan = new CameraMan(this);
		cameraMan.addLightSupport(1);
		try {
			VisualGameWorld world = (VisualGameWorld) level.getGameWorld();
			world.createLights();
		} catch (Exception e) {
			System.out.println ("GameWorld of VisualWorldStage must be a VisualGameWorld");
		}
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
		
		cameraMan.setLights();
		cameraMan.updateAndRenderLights();
		cameraMan.unsetCamera();
	}
	
	
	/** Get Input -- passes to CameraMan User requests
	 * 
	 * @param delta
	 */
	private void getInput (float delta) {
		
		//Camera Movement
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
			cameraMan.moveCamera(-20f * delta, 0);
		
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			cameraMan.moveCamera(20f * delta, 0);
		
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
			cameraMan.moveCamera( 0, -20f * delta);
		
		if (Gdx.input.isKeyPressed(Input.Keys.UP))
			cameraMan.moveCamera(0, 20f * delta);
		
		//Camera Zoom
		if (Gdx.input.isKeyPressed(Input.Keys.O))
			cameraMan.zoomCamera(-.5f * delta);
		
		if (Gdx.input.isKeyPressed(Input.Keys.P))
			cameraMan.zoomCamera(.5f * delta);
		
		
		//Virtual Camera Movement
		if (Gdx.input.isKeyPressed(Input.Keys.L))
			cameraMan.moveVCamera(.01f, 0);
		
		if (Gdx.input.isKeyPressed(Input.Keys.J))
			cameraMan.moveVCamera(-.01f, 0);
		
		if (Gdx.input.isKeyPressed(Input.Keys.I))
			cameraMan.moveVCamera(0, .01f);
		
		if (Gdx.input.isKeyPressed(Input.Keys.K))
			cameraMan.moveVCamera(0, -.01f);
		
		//Virtual Camera Zoom
		if (Gdx.input.isKeyPressed(Input.Keys.U))
			cameraMan.zoomVCamera(.01f);
		
		if (Gdx.input.isKeyPressed(Input.Keys.Y))
			cameraMan.zoomVCamera(-.01f);
	}
}
