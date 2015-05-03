package snake.imageUtilities;

import snake.levelSettings.WorldSettings;
import snake.levelSettings.WorldStage;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;


/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings
 */

public abstract class CameraMan {
	
	public static void moveCamera (WorldStage stage, float x, float y) {
		OrthographicCamera camera = (OrthographicCamera) stage.getCamera();
		camera.translate(x, y);
		
		WorldSettings.setCameraPosition(x, y);

		keepInBounds(stage);
	}
	
	
	public static void zoomCamera (WorldStage stage, float x, float y) {
		OrthographicCamera camera = (OrthographicCamera) stage.getCamera();
		camera.zoom += x;
		camera.zoom += y;
		
		camera.zoom = MathUtils.clamp(camera.zoom, WorldSettings.getMaxZoom(), WorldSettings.getMinZoom()); //Limit zoom
		 
		WorldSettings.setWorld2ScreenRatio(1/camera.zoom);
		
		keepInBounds(stage);
	}
	
	
	private static void keepInBounds (WorldStage stage) {
		float w, h, i, j;
		OrthographicCamera camera = (OrthographicCamera) stage.getCamera();

		if (WorldSettings.hasVirtualScreen()) {
			Rectangle viewport = stage.getClipBounds();
			w = viewport.width;
			h = viewport.height;
			i = viewport.y;
			j = viewport.x;
		}
		else {
			w = camera.viewportWidth;
			h = camera.viewportHeight;
			i = 0;
			j = 0;
		}
		float effectiveViewportWidth = w /2  * camera.zoom;
	    float effectiveViewportHeight = h/2  * camera.zoom;

	    camera.position.x = MathUtils.clamp(camera.position.x,
	    		effectiveViewportWidth / 2f,  WorldSettings.getWorldWidth() - effectiveViewportWidth / 2f);
	    camera.position.y = MathUtils.clamp(camera.position.y,
	    		effectiveViewportHeight / 2f, WorldSettings.getWorldHeight() - effectiveViewportHeight / 2f);
		
	}
	
}
