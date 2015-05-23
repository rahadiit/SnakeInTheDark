package snake.engine.creators;

import java.util.ArrayDeque;
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
 *  <br> TODO: Secure Screeen changes </br>
 *  
 *  
 *  <br> Create Screen as specified. </br>
 *  <br> has a stack (deque) of all active Screens </br>
 * @Author Mr.Strings
 */
public abstract class ScreenCreator {
	private static GameStart game;
	private static Deque <Screen> screenStack = new ArrayDeque<>();
	private static boolean updateRequested = false;
	
	/** Creates new String, but doesn't set it as current.
	 * @param Settings[] -- array of settings for desired screen. 
	 */
	public static Screen createScreen(String settings[]) {
		Screen screen;
		try {
			switch (settings[0].toLowerCase()) {
				case "snakehub":
				case "snake hub":
				case "mainmenu":
				case "main menu":
					screen = new SnakeHub();
					break;
				case "snakelevel":
				case "snake level":
					screen = new SnakeLevel(settings[1], settings[2]);
					break;
				default:
					System.out.println("Screen type not found.");
					return null;
		}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println ("Not enough parameters to create requested Screen.");
			return null;
		}

		return screen;
	}
	
	
	/** Working fine, but needs improvement. 
	 * @throws Exception */
	public static void addAndGo (String settings[]) throws Exception {
		
		try {
			Screen screen = createScreen(settings);
		
			screenStack.push(screen);
		
			game.setScreen(screen);
			
		}catch (IllegalStateException e) {
			throw new IllegalStateException ("Not enough space avaible for new Screen.");
		}
	}
	
	
	/** Removes Current Screen from Stack (if there is one) and adds created Screen
	 * with sent settings.
	 *  
	 * @param settings
	 * @throws Exception 
	 */
	public static void switchAndGo (String settings[]) throws Exception {
		try {
			
			if (screenStack.isEmpty() == false) {
				Screen removed = screenStack.pop();
				removed.dispose();
			}
		
			Screen screen = createScreen(settings);
			screenStack.push(screen);
			updateRequested = true;
			
		}catch (IllegalStateException e) {
			throw new IllegalStateException ("Not enough space avaible for new Screen.");
		}
	}
	
	
	/** Pops and disposes current screen from stack.
	 * @throws Exception -- if there is no screen left in stack 
	 * */
	public static void backToPrevious() throws Exception {
		Screen screen = screenStack.pop();
		screen.dispose();
		if (screenStack.isEmpty() == true)
			throw new Exception ("This is the first Screen.");
		else
			updateRequested = true;
	}
	
	public static boolean updateRequested() {
		return updateRequested;
	}
	
	public static void updateScreens () {
		if (screenStack.isEmpty() == false) {
			updateRequested = false;
			game.setScreen(screenStack.getFirst());
		}
	}
	
	/** Sets Game instance -- can only be done once */
	public static void setGameInstance(GameStart theGame) {
		if (game == null)
			game = theGame;
		else
			System.out.println("Cannot change game instance.");
	}

	
	/** Gets game batch -- doesn't prevent creation of another batch, but this isn't 
	 *  really recommended.
	 */
	public static SpriteBatch getBatch() {
		if (game != null && game.getBatch() instanceof SpriteBatch)
			return (SpriteBatch) game.getBatch();
		else {
			System.out.println("Game instance not yet created, or Batch isn't a SpriteBatch.");
			return null;
		}
	}
}
