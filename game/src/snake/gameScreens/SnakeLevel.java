package snake.gameScreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.scenes.scene2d.Stage;
import snake.core.SnakeStart;
import snake.interfacesAndAbstract.*;
import snake.levelSettings.HUDSettings;
import snake.levelSettings.WorldSettings;

/**                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * <br> Controls a generic game Level, with a World and HUD. </br>
 * @author Mr.Strings
 */

public class SnakeLevel implements Screen {

	public enum State {ACTIVE, NOINPUT, CUTSCENE, PAUSED}
	public enum Strategy {UPDATEFOCUS, DRAWFOCUS, NOFOCUS}
	
	private static float EXPECTED_DELTA_DRAW = 1/60, EXPECTED_DELTA_UPDATE = 1/60;
	private static int MAX_FRAMES_SKIPPED = 5, MAX_LOGIC_SKIPPED =  5;
	
	private SnakeStart game;
	private InputMultiplexer input;
	private Stage stageWorld, stageHUD;
	private GameWorld world;
	private HUD hud;
	private Cutscene cutscene;
	private PauseMenu pauseMenu;
	private State state = State.ACTIVE;
	private Strategy strategy = Strategy.UPDATEFOCUS;
	private int framesSkipped = 0, logicSkipped = 0;

	public SnakeLevel(SnakeStart game, String level) {
		this.game = game;

		// Creates GameWorld
		world = WorldSettings.createWorld("Generic level");
		// Creates HUD
		hud = HUDSettings.createHUD(world);

		// Creates a stage (world organizer)
		stageWorld = WorldSettings.createWorldStage(game.getBatch(), this, world);
		// Creates a stage (UI organizer)
		stageHUD = HUDSettings.createHUDStage(game, hud);

		// Adds world and HUD to the stages
		stageWorld.addActor(world);
		stageHUD.addActor(hud);
		
		// Let stages listen to input events
		input = new InputMultiplexer();
		input.addProcessor(stageWorld);
		input.addProcessor(stageHUD);
		 
		Gdx.input.setInputProcessor(input);
		
		
	}
	
	
	
	@Override
	public void show() {}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		getInput();
		
		switch (state) {
			case NOINPUT:
			case ACTIVE:
				onRender(delta);
				break;
				
			case PAUSED:
				pauseMenu.act(delta);
				pauseMenu.draw();
			case CUTSCENE:
				if (cutscene != null) {
					cutscene.act(delta);
					cutscene.draw();
				}
				break;
				
			default:
				break;
		}
	}
	
	
	private void onRender(float delta) {
		
		switch (strategy) {
			case UPDATEFOCUS:
				stageWorld.act(delta);
				
				stageHUD.act(delta);
			
				if (delta <= EXPECTED_DELTA_DRAW || framesSkipped < MAX_FRAMES_SKIPPED) {
					framesSkipped = 0;
					stageWorld.draw();
					stageHUD.draw();
				}
				else
					framesSkipped++;
				break;
		
			case DRAWFOCUS:
				if (delta <= EXPECTED_DELTA_UPDATE|| logicSkipped < MAX_LOGIC_SKIPPED) {
					logicSkipped = 0;
					stageWorld.act();
					stageHUD.act();
				}
				else
					logicSkipped++;
				stageWorld.draw();
				stageHUD.draw();
				break;
				
			case NOFOCUS:
				stageWorld.act();
				stageHUD.act();
			
				stageWorld.draw();
				stageHUD.draw();
				break;
			default:
				break; //Exception can be added
		}
		
		
	}

	@Override
	public void resize(int width, int height) {
		stageWorld.getViewport().update(width, height);
		stageHUD.getViewport().update(width, height);
		// stageWorld.getViewport().getCamera().translate(Gdx.graphics.getWidth(),
		// Gdx.graphics.getHeight(), 0);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose() {
		stageWorld.dispose();
		stageHUD.dispose();
		
		world.dispose();
		hud.dispose();
	}
	
	
	private void getInput () {
		if (Gdx.input.isKeyPressed(Input.Keys.F1)) {
			// set resolution to default and toogles full-screen
			Gdx.graphics.setDisplayMode(
					Gdx.graphics.getDesktopDisplayMode().width,
					Gdx.graphics.getDesktopDisplayMode().height,
					!Gdx.graphics.isFullscreen());
		}
		
		}

	
	public void setScreen(Screen screen) {
		game.setScreen(screen);
	}
	
	
	/* ------------------------------ Getters ------------------------------ */

	public GameWorld getGameWorld() {return world;}
	
	public HUD getHUD() {return hud;}
	
	public Stage getHudStage() {return stageHUD;}
	
	public Stage getWorldStage() {return stageWorld;}
	
	/* ------------------------------ Setters ------------------------------ */
	public void setGameState(State state) {this.state = state; }
	
	public void setStrategy (Strategy strategy) {this.strategy = strategy;}
}
