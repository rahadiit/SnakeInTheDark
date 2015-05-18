package snake.engine.creators;

import snake.engine.HUD;
import snake.engine.gameScreens.LevelStage;
import snake.engine.gameScreens.SnakeLevel;
import snake.hud.SnakeHUD;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 *                               
 * <br> Factory for HUD and HUDStages </br>
 * @author Mr.Strings (Modifiable according to need)
 */

public class HUDCreator {

	public static HUD createHUD (String type, String levelDataID) {
		return new SnakeHUD (type, levelDataID); //can be changed for another HUD
	}
	
	public static Viewport createHUDViewport(HUD hud) {
		Camera camera = new OrthographicCamera();
		return new StretchViewport(HUDSettings.getHudWidth(), HUDSettings.getHudHeight(), camera); //Aspect ratio Strategy for multiple screen resolutions
	}
	
	public static LevelStage createHUDStage (Batch batch, SnakeLevel level, HUD hud) {
		LevelStage stage;
		stage = new LevelStage(level, createHUDViewport(hud), batch);
		
		float width = stage.getViewport().getCamera().viewportWidth;
		float height = stage.getViewport().getCamera().viewportHeight;
		
		stage.getViewport().getCamera().translate(HUDSettings.getCameraPosX() - width/2, HUDSettings.getCameraPosY() - height/2, 0);
		
		return  stage;
	}
	
}
