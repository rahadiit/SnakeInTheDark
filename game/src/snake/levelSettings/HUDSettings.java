package snake.levelSettings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import snake.hud.SnakeHUD;
import snake.interfacesAndAbstract.GameWorld;
import snake.interfacesAndAbstract.HUD;



/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings (modifiable according to need)
 */

public class HUDSettings {
	private static float HUD_SIZEX = Gdx.graphics.getWidth(),
						 HUD_SIZEY = Gdx.graphics.getHeight();
	private static float CAM_SIZEX = 1, CAM_SIZEY = 1; //Relative to HUD(Changeable)
	
	public static HUD createHUD (GameWorld world) {
		return new SnakeHUD (world); //can be changed for another HUD
	}
	
	public static Viewport createHUDViewport(HUD hud) {
		Camera camera = new OrthographicCamera(HUD_SIZEX * CAM_SIZEX, HUD_SIZEY * CAM_SIZEY);
		camera.translate(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 0);  // Going to the middle
		camera.update();
		return new ScreenViewport(camera); //Aspect ratio Strategy for multiple screen resolutions
	}
	
}
