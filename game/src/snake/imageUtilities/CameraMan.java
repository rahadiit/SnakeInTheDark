package snake.imageUtilities;

import snake.levelSettings.WorldSettings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;


/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings
 */

public class CameraMan {
	private OrthographicCamera camera;
	private boolean isVirtual = false;
	
	public CameraMan (Stage stage) {
		
		/* Get Stage Camera */
		if (stage.getCamera() instanceof OrthographicCamera)
			camera = (OrthographicCamera) stage.getCamera();
		else {
			throw new UnsupportedOperationException("CameraMan only works with OrthographicCamera for now");
		}
	}
	
	public void setCamera () {
		     
		if (WorldSettings.hasVirtualScreen()) {
			Gdx.gl.glViewport((int)(WorldSettings.getVScreenX_Porc() * Gdx.graphics.getWidth()),
							  (int)(WorldSettings.getVScreenY_Porc() * Gdx.graphics.getHeight()),
							  (int)(WorldSettings.getVScreenWidth_Porc() * Gdx.graphics.getWidth()),
							  (int)(WorldSettings.getVScreenHeight_Porc()  * Gdx.graphics.getHeight()));
			isVirtual = true;
		}
	}
	
	public void unsetCamera () throws IllegalStateException {
		Gdx.gl.glViewport(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		if (isVirtual) {
			isVirtual = false;
		}
	}
	
	public void moveCamera (Batch batch, float x, float y) {
		camera.translate(x, y); //Translate camera
		keepInBounds();

		WorldSettings.setCameraPosition(camera.position.x, camera.position.y);
		
	}
	
	
	
	public void zoomCamera (float zoom) {
		camera.zoom += zoom;
		camera.zoom = MathUtils.clamp(camera.zoom, WorldSettings.getMaxZoom(), WorldSettings.getMinZoom());
		WorldSettings.setWorld2ScreenRatio(1/camera.zoom);
		keepInBounds();
		
	}
	
	
	private void keepInBounds () {
		float effectiveViewportWidth = camera.viewportWidth * camera.zoom;
        float effectiveViewportHeight = camera.viewportHeight * camera.zoom;

        camera.position.x = MathUtils.clamp(camera.position.x, effectiveViewportWidth / 2f, 100 - effectiveViewportWidth / 2f);
        camera.position.y = MathUtils.clamp(camera.position.y, effectiveViewportHeight / 2f, 100 - effectiveViewportHeight / 2f);
    }
	
}
