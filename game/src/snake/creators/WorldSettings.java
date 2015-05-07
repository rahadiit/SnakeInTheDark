package snake.creators;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import snake.gameScreens.SnakeLevel;
import snake.interfacesAndAbstract.GameWorld;
import snake.map.WorldMap;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * @author Mr.Strings (Modifiable according to need)
 * 
 * Controls World Parameters, such as size, camera infos, virtual Screen Parameters, etc.
 */
public class WorldSettings {
	private static float WORLD_WIDTH = 100, WORLD_HEIGHT = 100; //Arbitrary coordinate System.
	private static float WORLD2SCREEN_RATIO = 1f; //Relative to World (Changeable)
	private static float CAMERAPOSITIONX = 50,  CAMERAPOSITIONY = 50; //center of camera position (Changeable)
	private static float MAXZOOM = .1f, MINZOOM = 1f;
	private static boolean HAS_VIRTUAL_SCREEN = true; //Defines if World camera occupies whole screen or is clipped
	private static float VSCREEN_X_PORC = .25f, VSCREEN_Y_PORC = .25f; // Starting point of Virtual Screen (if set) (porcentage to Screen Size
	private static float VSCREEN_WIDTH_PORC = .5f, VSCREEN_HEIGHT_PORC = .5f; //Size of Virtual Screen (porcentage to Screen Size)
	private static float VSCREEN_MINSIZE = .3f, VSCREEN_MAXSIZE = 1;
	//IMPORTANT NOTE -- VSCREEN is UNreliable if it goes beyond the Screen size
	
	/** Set the WorldType of the return line to create a custom World class in game (Changeable)
	 * 
	 * @author Mr.Strings (Modifiable according to need)
	 * 
	 * @param levelData
	 * @return GameWorld
	 */
	public static GameWorld createWorld (String levelData) { 
		
		// Set the WorldType of the return to create a custom World class in game 
		return new WorldMap(/*Add other parameters of choice*/);
	}
	
	/** Creates Scene2d Stage.
	 * 
	 * @author Mr.Strings (Modifiable according to need)
	 * 
	 * @param batch
	 * @param level - Current level
	 * @param world - World to be Staged
	 * @return Stage - Stage created
	 */
	public static Stage createWorldStage (Batch batch, SnakeLevel level, GameWorld world) {
		Stage stage;
		stage = new WorldStage(level, WorldSettings.createWorldViewport(world), batch);
		
		float width = stage.getViewport().getCamera().viewportWidth;
		float height = stage.getViewport().getCamera().viewportHeight;
		
		OrthographicCamera camera = (OrthographicCamera) stage.getViewport().getCamera();
		camera.translate(CAMERAPOSITIONX - width/2, CAMERAPOSITIONY - height/2, 0);
		
		return  stage;
	}
	
	/** Creates Viewport for GameWorld to fit
	 * 
	 * @param world
	 * @return Viewport
	 */
	public static Viewport createWorldViewport(GameWorld world) {
		OrthographicCamera camera = new OrthographicCamera();
		
		//creates viewport that stretches to fit resolution
		Viewport viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
		
		camera.zoom = 1/WORLD2SCREEN_RATIO;
		
		return viewport;
	}
	
	
	
	
	/* ------------------------------ Getters ------------------------------ */
	
	/** Gets World Width - arbitrary coordinate System
	 * 
	 * @return WORLD_WIDTH
	 */
	public static float getWorldWidth() {
		return WORLD_WIDTH;
	}
	
	/** Gets World Height - arbitrary coordinate System
	 * 
	 * @return WORLD_WIDTH
	 */
	public static float getWorldHeight() {
		return WORLD_HEIGHT;
	}
	
	/** Gets World/Screen ratio
	 * 
	 * @return ratio
	 */
	public static float getWorld2ScreenRatio() {
		return WORLD2SCREEN_RATIO;
	}
	
	/** Gets Camera Center coordinate X - arbitrary coordinate System
	 * 
	 * @return CameraCenterX
	 */
	public static float getCameraPosX() {
		return CAMERAPOSITIONX;
	}
	
	/** Gets Camera Center coordinate Y - arbitrary coordinate System
	 * 
	 * @return CameraCenterY
	 */
	public static float getCameraPosY() {
		return CAMERAPOSITIONY;
	}
	
	/** Gets Camera's max zoom
	 * 
	 * @return MAXZOOM
	 */
	public static float getMaxZoom() {
		return MAXZOOM;
	}
	
	/** Gets Camera's minimum zoom
	 * 
	 * @return MINZOOM
	 */
	public static float getMinZoom() {
		return MINZOOM;
	}
	
	
	/** True if virtual screen is toggled on
	 * 
	 * @return boolean
	 */
	public static boolean hasVirtualScreen () {
		return HAS_VIRTUAL_SCREEN;
	}
	
	/** gets Virtual Screen starting point X(Percentage to Screen size
	 * 
	 * @return percent
	 */
	public static float getVScreenX_Porc() {
		return VSCREEN_X_PORC;
	}
	
	/** gets Virtual Screen starting point Y (Percentage to Screen size
	 * 
	 * @return percent
	 */
	public static float getVScreenY_Porc() {
		return VSCREEN_Y_PORC;
	}
	
	/** gets Virtual Screen Width (Percentage to Screen size
	 * 
	 * @return percent
	 */
	public static float getVScreenWidth_Porc() {
		return VSCREEN_WIDTH_PORC;
	}
	
	/** gets Virtual Screen Height (Percentage to Screen size
	 * 
	 * @return percent
	 */
	public static float getVScreenHeight_Porc() {
		return VSCREEN_HEIGHT_PORC;
	}
	
	/** gets Virtual Screen MaxSize (Percentage to Screen size
	 * 
	 * @return percent
	 */
	public static float getVScreenMaxSize() {
		return VSCREEN_MAXSIZE;
	}
	
	/** gets Virtual Screen MinSize (Percentage to Screen size
	 * 
	 * @return percent
	 */
	public static float getVScreenMinSize() {
		return VSCREEN_MINSIZE;
	}
	/* ------------------------------ Setters ------------------------------ */
	
	/** Sets Camera Center coordinates - arbitrary coordinate System.*/
	public static void setCameraPosition(float posX, float posY) {
		CAMERAPOSITIONX = posX;
		CAMERAPOSITIONY = posY;
	}
	
	/** Sets World size - arbitrary coordinate System.*/
	public static void setWorldSSize(float sizex, float sizey) {
		WORLD_WIDTH = sizex;
		WORLD_HEIGHT = sizey;
	}
	
	/** Sets World/screen ratio. */
	public static void setWorld2ScreenRatio(float ratio) {
		WORLD2SCREEN_RATIO = ratio;
	}
	
	/** Toggles virtual screen.*/
	public static void toggleVirtualScreen (boolean option) {
		HAS_VIRTUAL_SCREEN = option;
	}
	
	/** Sets virtual screen (viewport) to draw */
	public static boolean setVirtualScreen (float x, float y, float width, float height) {
		if (x >= 0 && x + width <= 1) {
			VSCREEN_X_PORC = x;
			VSCREEN_WIDTH_PORC = width;
		}
		else
			return false;
		
		
		if (y >= 0 && y + height <= 1) {
			VSCREEN_Y_PORC = y;
			VSCREEN_HEIGHT_PORC = height;
		}
		else
			return false;

		return true;
	}
	
	
}
