package snake.levelSettings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
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
	private static float WORLD2SCREEN_RATIOX = 0.5f, WORLD2SCREEN_RATIOY = 0.5f; //Relative to World (Changeable)
	
	
	// Set the WorldType of the return line to create a custom World class in game (Changeable)
	public static GameWorld createWorld (SnakeStart game, String levelData) { 
		
		// Set the WorldType of the return to create a custom World class in game 
		return new WorldMap(game/*Add other parameters of choice*/);
	}
	
	
	public static Viewport createWorldViewport(GameWorld world) {
		Camera camera = new OrthographicCamera();
		
		Viewport viewport = new StretchViewport(WORLD_SIZEX/WORLD2SCREEN_RATIOX, WORLD_SIZEY/WORLD2SCREEN_RATIOY, camera); //Aspect ratio Strategy for multiple screen resolutions
		
		//viewport.getCamera().translate(WORLD_SIZEX/2, WORLD_SIZEY/2, 0);
		
		return viewport;
	}
	
	
	public static void setWorldSSize(float sizex, float sizey) {
		WORLD_SIZEX = sizex;
		WORLD_SIZEY = sizey;
	}
	
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

	
}
