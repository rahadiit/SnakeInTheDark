package snake.levelSettings;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
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
	private static float WORLD2SCREEN_RATIO = .5f; //Relative to World (Changeable)
	private static float CAMERAPOSITIONX = 50,  CAMERAPOSITIONY = 50; //center of camera position
	private static float MAXZOOM = .3f, MINZOOM = 2f;
	private static boolean HAS_VIRTUAL_SCREEN = false; //Defines if World camera occupies whole screen or is clipped
	private static float VIRTUALSCREEN_WIDTH = 100, VIRTUALSCREEN_HEIGHT = 100;
	private static float VIRTUALSCREENX = 0, VIRTUALSCREENY = 0;
	private static Rectangle VIRTUAL_SCREEN; //check correspondent getter for inicialization
	
	// Set the WorldType of the return line to create a custom World class in game (Changeable)
	public static GameWorld createWorld (String levelData) { 
		
		// Set the WorldType of the return to create a custom World class in game 
		return new WorldMap(/*Add other parameters of choice*/);
	}
	
	
	public static Viewport createWorldViewport(GameWorld world) {
		OrthographicCamera camera = new OrthographicCamera();
		
		//creates viewport that stretches to fit resolution
		Viewport viewport = new StretchViewport(WORLD_SIZEX, WORLD_SIZEY, camera);
		
		camera.zoom = 1/WORLD2SCREEN_RATIO;
		
		
		return viewport;
	}
	
	public static Stage createWorldStage (SnakeStart game, GameWorld world) {
		Stage stage;
		stage = new WorldStage(WorldSettings.createWorldViewport(world), game.getBatch());
		
		float width = stage.getViewport().getCamera().viewportWidth;
		float height = stage.getViewport().getCamera().viewportHeight;
		
		OrthographicCamera camera = (OrthographicCamera) stage.getViewport().getCamera();
		camera.translate(CAMERAPOSITIONX - width/2, CAMERAPOSITIONY - height/2, 0);
		
		return  stage;
	}
	
	
	/* ------------------------------ Getters ------------------------------ */
	public static float getWorldWidth() {
		return WORLD_SIZEX;
	}
	
	public static float getWorldHeight() {
		return WORLD_SIZEY;
	}
	
	public static float getWorld2ScreenRatio() {
		return WORLD2SCREEN_RATIO;
	}
	public static float getCameraPosX() {
		return CAMERAPOSITIONX;
	}
	
	public static float getCameraPosY() {
		return CAMERAPOSITIONY;
	}
	
	public static float getMaxZoom() {
		return MAXZOOM;
	}
	
	public static float getMinZoom() {
		return MINZOOM;
	}
	
	public static boolean hasVirtualScreen () {
		return HAS_VIRTUAL_SCREEN;
	}
	
	public static float getVScreenWidth() {
		return VIRTUALSCREEN_WIDTH;
	}
	
	public static float getVScreenHeight() {
		return VIRTUALSCREEN_HEIGHT;
	}
	public static float getVScreenX() {
		return VIRTUALSCREENX;
	}
	
	public static float getVScreenY() {
		return VIRTUALSCREENX;
	}
	/* ------------------------------ Setters ------------------------------ */
	public static void setCameraPosition(float posX, float posY) {
		CAMERAPOSITIONX = posX;
		CAMERAPOSITIONY = posY;
	}
	
	public static void setWorldSSize(float sizex, float sizey) {
		WORLD_SIZEX = sizex;
		WORLD_SIZEY = sizey;
	}
	
	public static void setWorld2ScreenRatio(float ratio) {
		WORLD2SCREEN_RATIO = ratio;
	}
	
	public static void setVirtualScreen (boolean option) {
		HAS_VIRTUAL_SCREEN = option;
	}
	
	
}
