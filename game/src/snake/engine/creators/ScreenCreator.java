package snake.engine.creators;

import java.util.Stack;
import snake.engine.GameStart;
import snake.engine.gameScreens.SnakeHub;
import snake.engine.gameScreens.SnakeLevel;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *          
 *  <br> Create Screen as specified. </br>
 *  <br> has an array of all active Screens (NOT YET DONE) </br>
 * @Author Mr.Strings
 */
public abstract class ScreenCreator {
	private static GameStart game;
	private Stack <Screen> screenStack = new Stack<>();
	
	
	public static Screen createScreen(String screenType, String subtype, String subSubType) {
		switch (screenType.toLowerCase()) {
			case "snakehub":
			case "snake hub":
				return new SnakeHub();
			case "snakelevel":
			case "snake level":
				return new SnakeLevel(subtype, subSubType);
				
			default:
				System.out.println("Screen type not found.");
				return null;
		}
	}
	
	public static void goToScreen (String screenType, String subtype, String subSubType) {
		game.setScreen(createScreen(screenType, subtype, subSubType));
	}
	
	public static void setGameInstance(GameStart theGame) {
		if (game == null)
			game = theGame;
		else
			System.out.println("Cannot change game instance.");
	}
	
	public static GameStart getGameInstance() {
		return game;
	}
	
	public static SpriteBatch getBatch() {
		if (game != null && game.getBatch() instanceof SpriteBatch)
			return (SpriteBatch) game.getBatch();
		else {
			System.out.println("Game instance not yet created, or Batch isn't a SpriteBatch.");
			return null;
		}
	}
}
