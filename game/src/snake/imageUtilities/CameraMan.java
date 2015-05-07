package snake.imageUtilities;

import snake.creators.WorldSettings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *                                
 * <br> Useful for controlling a camera in a Scene2d Stage. Can Zoom, translate and supports virtual
 * screen size based on WorldSettings Data.</br>
 * @author Mr.Strings
 * 
 */

public class CameraMan {
	private OrthographicCamera camera;
	private boolean isVirtual = false;
	
	/** Creates CameraMan with Stage
	 * Note: Only works with OrthographicCamera
	 * @param stage
	 * @Throws UnsupportedOperationException - in case stage passed has unsupported camera type
	 */
	public CameraMan (Stage stage) {
		
		/* Get Stage Camera */
		if (stage.getCamera() instanceof OrthographicCamera)
			camera = (OrthographicCamera) stage.getCamera();
		else {
			throw new UnsupportedOperationException("CameraMan only works with OrthographicCamera for now");
		}
	}
	
	/** Sets virtual Screen to draw, according to WorldSettings Class
	 * @see snake.levelSettings.WorldSettings
	 */
	public void setCamera () {
		     
		if (WorldSettings.hasVirtualScreen()) {
			Gdx.gl.glViewport((int)(WorldSettings.getVScreenX_Porc() * Gdx.graphics.getWidth()),
							  (int)(WorldSettings.getVScreenY_Porc() * Gdx.graphics.getHeight()),
							  (int)(WorldSettings.getVScreenWidth_Porc() * Gdx.graphics.getWidth()),
							  (int)(WorldSettings.getVScreenHeight_Porc()  * Gdx.graphics.getHeight()));
			isVirtual = true;
		}
	}
	/** "Unsets" virtual Screen
	 */
	public void unsetCamera () {
		Gdx.gl.glViewport(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		if (isVirtual) {
			isVirtual = false;
		}
	}
	
	/** Translate Camera keeping it in WorldBounds
	 * @see CameraMan#keepInBounds()
	 */
	public void moveCamera (float x, float y) {
		camera.translate(x, y); //Translate camera
		keepInBounds();

		WorldSettings.setCameraPosition(camera.position.x, camera.position.y);
		
	}
	
	
	/** Zooms Camera keeping it in WorldBounds
	 * @see CameraMan#keepInBounds()
	 */
	public void zoomCamera (float zoom) {
		camera.zoom += zoom;
		camera.zoom = MathUtils.clamp(camera.zoom, WorldSettings.getMaxZoom(), WorldSettings.getMinZoom());
		WorldSettings.setWorld2ScreenRatio(1/camera.zoom);
		keepInBounds();
		
	}
	
	/** Keeps Camera in World Bounds. Addapted from link below
	 * @see https://github.com/libgdx/libgdx/wiki/Orthographic-camera
	*/
	private void keepInBounds () {
		float effectiveViewportWidth = camera.viewportWidth * camera.zoom;
        float effectiveViewportHeight = camera.viewportHeight * camera.zoom;

        camera.position.x = MathUtils.clamp(camera.position.x, effectiveViewportWidth / 2f, 100 - effectiveViewportWidth / 2f);
        camera.position.y = MathUtils.clamp(camera.position.y, effectiveViewportHeight / 2f, 100 - effectiveViewportHeight / 2f);
    }
	
	/** translates VirtualScren keeping it in Bounds
	 */
	public void moveVCamera (float x, float y) {
		WorldSettings.setVirtualScreen(MathUtils.clamp(WorldSettings.getVScreenX_Porc() + x, 0, 1 - WorldSettings.getVScreenWidth_Porc()), 
									   MathUtils.clamp(WorldSettings.getVScreenY_Porc() + y, 0, 1 - WorldSettings.getVScreenHeight_Porc()),
									   WorldSettings.getVScreenWidth_Porc(),
									   WorldSettings.getVScreenHeight_Porc());
	}
	
	public void zoomVCamera (float zoom) {
		float beforeX = WorldSettings.getVScreenWidth_Porc();
		float afterX = (float) MathUtils.clamp(beforeX/(1 + zoom), WorldSettings.getVScreenMinSize(), WorldSettings.getVScreenMaxSize());
		float beforeY = WorldSettings.getVScreenWidth_Porc();
		float afterY = (float) MathUtils.clamp(beforeY/(1 + zoom),WorldSettings.getVScreenMinSize(), WorldSettings.getVScreenMaxSize());
		WorldSettings.setVirtualScreen(MathUtils.clamp(WorldSettings.getVScreenX_Porc() - (afterX - beforeX)/2, 0, 1 - afterX),
									   MathUtils.clamp(WorldSettings.getVScreenY_Porc() - (afterY - beforeY)/2, 0, 1 - afterY),
										afterX, afterY);
	}
	
	
	
}
