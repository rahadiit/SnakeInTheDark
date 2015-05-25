package snake.engine.creators;

import snake.engine.BlankHUD;
import snake.engine.HUD;
import snake.engine.core.SnakeScreen;
import snake.engine.stages.LevelStage;
import snake.hud.SnakeHUD;
import snake.menus.SnakeHub;
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
		HUD hud;
		
		switch (type.toLowerCase()) {
		
			case "templemap":
			case "temple map":
			case "forestmap":
			case "forest map":
				hud = new SnakeHUD (levelDataID); //can be changed for another HUD
				break;
			case "snakehub":
			case "snake hub":
				hud = new SnakeHub();
				break;
			case "blank":
				hud = new BlankHUD();
				break;
			default:
				System.out.println("HUD type " + type + " not found");
				return null;
		}
		
		return hud;
	}
	
	public static Viewport createHUDViewport(HUD hud) {
		Camera camera = new OrthographicCamera();
		return new StretchViewport(HUDSettings.getHudWidth(), HUDSettings.getHudHeight(), camera); //Aspect ratio Strategy for multiple screen resolutions
	}
	
	public static LevelStage createHUDStage (Batch batch, SnakeScreen level, HUD hud) {
		LevelStage stage;
		stage = new LevelStage(level, createHUDViewport(hud), batch);
		
		float width = stage.getViewport().getCamera().viewportWidth;
		float height = stage.getViewport().getCamera().viewportHeight;
		
		stage.getViewport().getCamera().translate(HUDSettings.getCameraPosX() - width/2, HUDSettings.getCameraPosY() - height/2, 0);
		
		return  stage;
	}
	
}
