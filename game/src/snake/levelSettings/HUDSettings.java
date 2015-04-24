package snake.levelSettings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import snake.core.SnakeStart;
import snake.hud.SnakeHUD;
import snake.interfacesAndAbstract.GameWorld;
import snake.interfacesAndAbstract.HUD;



/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings (modifiable according to need)
 */

public class HUDSettings {
	private static float HUD_SIZEX = 100, HUD_SIZEY = 100;
	private static float CAM_SIZEX = 1, CAM_SIZEY = 1; //Relative to HUD(Changeable)
	private static float CAMERAPOSITIONX = 50, CAMERAPOSITIONY = 50;
	
	public static HUD createHUD (GameWorld world) {
		return new SnakeHUD (world); //can be changed for another HUD
	}
	
	public static Viewport createHUDViewport(HUD hud) {
		Camera camera = new OrthographicCamera(HUD_SIZEX * CAM_SIZEX, HUD_SIZEY * CAM_SIZEY);
		return new ScreenViewport(camera); //Aspect ratio Strategy for multiple screen resolutions
	}
	
	public static Stage createHUDStage (SnakeStart game,HUD hud) {
		Stage stage;
		stage = new Stage(HUDSettings.createHUDViewport(hud), game.getBatch());
		
		stage.getViewport().getCamera().translate(CAMERAPOSITIONX, CAMERAPOSITIONY, 0);
		
		return  stage;
	}
	
	
}
