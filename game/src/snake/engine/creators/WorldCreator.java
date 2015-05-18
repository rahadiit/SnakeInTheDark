package snake.engine.creators;

import snake.engine.GameWorld;
import snake.engine.gameScreens.LevelStage;
import snake.engine.gameScreens.SnakeLevel;
import snake.map.types.ForestMap_test;
import snake.map.types.TempleMap_test;
import snake.visuals.enhanced.VisualWorldStage;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * 
 * <br> Factory for GameWorlds and GameStages </br>
 * 
 * <br>
 * 		Note: Customization in Factory type methods (such as createWorld() and createWorldStage()) and
 * 		attributes is recommended.
 * </br>
 * @author Mr.Strings 
 * 
 * 
 * 
 */
public abstract class WorldCreator {

	/** Set the WorldType of the return line to create a custom World class in game (Changeable)
	 * 
	 * @author Mr.Strings (Modifiable according to need)
	 * 
	 * @param levelData
	 * @return GameWorld
	 */
	public static GameWorld createWorld (String type, String levelDataID) { 
		
		switch (type.toLowerCase()) {
			case "forestmap":
			case "forest map":
				return new ForestMap_test(levelDataID);
			case "templemap":
			case "temple map":
				return new TempleMap_test(levelDataID);	
				
			// Set the WorldType of the return to create a custom World class in game
			default:
				System.out.println("Map type " + type + " not found");
				return null;
		}
		
		
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
	public static LevelStage createWorldStage (Batch batch, SnakeLevel level, GameWorld world) {
		LevelStage stage;
		
		 //change StageType here
		stage = new VisualWorldStage(level, createWorldViewport(world), batch);
		
		
		float width = stage.getViewport().getCamera().viewportWidth;
		float height = stage.getViewport().getCamera().viewportHeight;
		
		OrthographicCamera camera = (OrthographicCamera) stage.getViewport().getCamera();
		camera.translate(WorldSettings.getCameraPosX() - width/2, WorldSettings.getCameraPosY() - height/2, 0);
		
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
		Viewport viewport = new StretchViewport(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight(), camera);
		
		camera.zoom = 1/WorldSettings.getWorld2ScreenRatio();
		
		return viewport;
	}
}
