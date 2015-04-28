package snake.levelSettings;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import snake.core.SnakeStart;
import snake.interfacesAndAbstract.GameWorld;
import snake.map.WorldMap;

/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings (modifiable according to need)
 */
public class WorldSettings {
	private static float WORLD_SIZEX = 100, WORLD_SIZEY = 100; //Arbitrary coordinate System.
	private static float WORLD2SCREEN_RATIOX = 2, WORLD2SCREEN_RATIOY = 2; //Relative to World (Changeable)
	private static float CAMERAPOSITIONX = 50,  CAMERAPOSITIONY = 50; //center of camera position
	
	// Set the WorldType of the return line to create a custom World class in game (Changeable)
	public static GameWorld createWorld (SnakeStart game, String levelData) { 
		
		// Set the WorldType of the return to create a custom World class in game 
		return new WorldMap(game/*Add other parameters of choice*/);
	}
	
	
	public static Viewport createWorldViewport(GameWorld world) {
		Camera camera = new OrthographicCamera();
		
		
		//creates viewport that stretches to fit resolution
		Viewport viewport = new StretchViewport(WORLD_SIZEX/WORLD2SCREEN_RATIOX, WORLD_SIZEY/WORLD2SCREEN_RATIOY, camera); //Aspect ratio Strategy for multiple screen resolutions
		
		return viewport;
	}
	
	public static Stage createWorldStage (SnakeStart game, GameWorld world) {
		Stage stage;
		stage = new Stage(WorldSettings.createWorldViewport(world), game.getBatch());
		
		float width = stage.getViewport().getCamera().viewportWidth;
		float height = stage.getViewport().getCamera().viewportHeight;
		
		stage.getViewport().getCamera().translate(CAMERAPOSITIONX - width/2, CAMERAPOSITIONY - height/2, 0);
		
		return  stage;
	}
	
	
	/* ------------------------------ Getters ------------------------------ */
	public static float getWorldWidth() {
		return WORLD_SIZEX;
	}
	
	public static float getWorldHeight() {
		return WORLD_SIZEY;
	}
	
	public static float getWorld2ScreenRatioX() {
		return WORLD2SCREEN_RATIOX;
	}
	
	public static float getWorld2ScreenRatioY() {
		return WORLD2SCREEN_RATIOY;
	}
	
	public static float getCameraPosX() {
		return CAMERAPOSITIONX;
	}
	
	public static float getCameraPosY() {
		return CAMERAPOSITIONY;
	}

	
	/* ------------------------------ Setters ------------------------------ */
	public static void moveCamera(float posX, float posY) {
		CAMERAPOSITIONX += posX;
		CAMERAPOSITIONY += posY;
	}
	
	public static void setWorldSSize(float sizex, float sizey) {
		WORLD_SIZEX = sizex;
		WORLD_SIZEY = sizey;
	}
	
	public static void setWorld2ScreenRatio(float ratioX, float ratioY) {
		WORLD2SCREEN_RATIOX = ratioX;
		WORLD2SCREEN_RATIOY = ratioY;
	}
	
	
}
