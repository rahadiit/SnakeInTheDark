package snake.engine.creators;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import snake.engine.GameStart;
import snake.engine.gameScreens.SnakeHub;
import snake.engine.gameScreens.SnakeLevel;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 *  
 *  <br> TODO: SET PROPER USE OF SCREEN STACK </br>
 *  
 *  
 *  <br> Create Screen as specified. </br>
 *  <br> has an array of all active Screens (NOT YET DONE) </br>
 * @Author Mr.Strings
 */
public abstract class ScreenCreator {
	private static GameStart game;
	private static Deque <ArrayList<Screen>> screenStack = new ArrayDeque<>();
	
	
	public static Screen createScreen(String settings[]) {
		Screen screen;
		
		switch (settings[0].toLowerCase()) {
			case "snakehub":
			case "snake hub":
			case "mainmenu":
			case "main menu":
				screen = new SnakeHub();
				break;
			case "snakelevel":
			case "snake level":
				try {
					screen = new SnakeLevel(settings[1], settings[2]);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println ("Not enough parameters to create Screen");
					return null;
				}
				break;
			default:
				System.out.println("Screen type not found.");
				return null;
		}
		
		//screenStack.getFirst().add(screen);
		
		return screen;
	}
	
	public static void goToScreen (String settings[]) {
		game.setScreen(createScreen(settings));
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
