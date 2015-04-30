package snake.gameScreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import snake.core.SnakeStart;
import snake.interfacesAndAbstract.*;
import snake.levelSettings.HUDSettings;
import snake.levelSettings.WorldSettings;

/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings
 */

public class SnakeLevel implements Screen {

	public static final int ACTIVE = 1;
	public static final int NOINPUT = -1;
	public static final int CUTSCENE = 2;
	public static final int PAUSED = -2;
	public static final Boolean UPDATEFOCUS = true;
	public static final Boolean DRAWFOCUS = false;
	public static final Boolean NOFOCUS = null;
	private static float EXPECTED_DELTA_DRAW = 1/60, EXPECTED_DELTA_UPDATE = 1/60;
	private static int MAX_FRAMES_SKIPPED = 5, MAX_LOGIC_SKIPPED =  5;
	
	private SnakeStart game;
	private SpriteBatch batch;
	private InputMultiplexer input;
	private BitmapFont font;
	private Stage stageWorld, stageHUD;
	private GameWorld world;
	private HUD hud;
	private Animation cutscene;
	private int state = ACTIVE;
	private float time;
	private boolean strategy = UPDATEFOCUS;
	private int framesSkipped = 0, logicSkipped = 0;

	public SnakeLevel(SnakeStart game, String level) {
		this.game = game;
		this.batch = game.getBatch();

		// Creates GameWorld
		world = WorldSettings.createWorld(game, "Generic level");
		// Creates HUD
		hud = HUDSettings.createHUD(world);

		// Creates a stage (world organizer)
		stageWorld = WorldSettings.createWorldStage(game, world);
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
	public void show() {
		font = new BitmapFont(Gdx.files.internal("ak_sc_o.fnt"), false);
		font.setColor(Color.GREEN);
		new String("Well done, you pressed it!");
	}

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
				
			case CUTSCENE:
				if (cutscene != null)
					batch.draw(cutscene.getKeyFrame(time), 0, 0);
				time += delta;
				break;
				
			default:
				break;
		}
	}
	
	
	private void onRender(float delta) {
		
		if (strategy == UPDATEFOCUS) {
			stageWorld.act(delta);
			stageHUD.act(delta);
		
			if (delta <= EXPECTED_DELTA_DRAW || framesSkipped < MAX_FRAMES_SKIPPED) {
				framesSkipped = 0;
				stageWorld.draw();
				stageHUD.draw();
			}
			else
				framesSkipped++;
		}
		else if (strategy == DRAWFOCUS){
			if (delta <= EXPECTED_DELTA_UPDATE|| logicSkipped < MAX_LOGIC_SKIPPED) {
				logicSkipped = 0;
				stageWorld.act();
				stageHUD.act();
			}
			else
				logicSkipped++;

			stageWorld.draw();
			stageHUD.draw();
		} else {
			stageWorld.act();
			stageHUD.act();
			
			stageWorld.draw();
			stageHUD.draw();
			
		}
		
		// Draw fps
		batch.begin();
		font.setColor(Color.GREEN);
		font.setScale(1f);
		font.draw(batch, "fps: " + Gdx.graphics.getFramesPerSecond(), Gdx.graphics.getWidth() * 5/100, Gdx.graphics.getHeight() * 105/100);
		batch.end();
		//Ends drawing
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
	}
	
	
	private void getInput () {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && 
				WorldSettings.getCameraPosX() - stageWorld.getCamera().viewportWidth/2 > 0)
			moveCamera(-0.2f, 0);
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) &&
				stageWorld.getCamera().viewportWidth/2 + WorldSettings.getCameraPosX() < WorldSettings.getWorldWidth())
			moveCamera(0.2f, 0);
		
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && 
				WorldSettings.getCameraPosY() - stageWorld.getCamera().viewportHeight/2 > 0)
			moveCamera(0, -0.2f);
		if (Gdx.input.isKeyPressed(Input.Keys.UP) &&
				stageWorld.getCamera().viewportHeight/2 + WorldSettings.getCameraPosY() < WorldSettings.getWorldHeight())
			moveCamera(0, 0.2f);
		
		if (Gdx.input.isKeyPressed(Input.Keys.O) && 
				WorldSettings.getWorld2ScreenRatioX() < 5 && WorldSettings.getWorld2ScreenRatioY() < 5)
			zoomCamera(.9f, .9f);
		if (Gdx.input.isKeyPressed(Input.Keys.P) && 
				WorldSettings.getWorld2ScreenRatioX() > 1 && WorldSettings.getWorld2ScreenRatioY() > 1)
			zoomCamera(1.1f, 1.1f);
	}
	
	
	public void moveCamera (float x, float y) {
		stageWorld.getCamera().translate(x, y, 0);
		
		WorldSettings.moveCamera(x, y);
	}
	
	
	public void zoomCamera (float x, float y) {
		stageWorld.getCamera().viewportWidth *= x;
		stageWorld.getCamera().viewportHeight *= y;
		
		WorldSettings.setWorld2ScreenRatio(WorldSettings.getWorldWidth()/stageWorld.getCamera().viewportWidth,
				WorldSettings.getWorldHeight()/stageWorld.getCamera().viewportHeight);
		
	}
	

	
	
	
	
	/* ------------------------------ Getters ------------------------------ */
	public Viewport getWorldViewport() {return stageWorld.getViewport();}

	public Viewport getHUDViewPort() {return stageHUD.getViewport();}

	public GameWorld getGameWorld() {return world;}
	
	public HUD getHUD() {return hud;}
	
	/* ------------------------------ Setters ------------------------------ */
	public boolean setGameState(int state) {
		if (state >= -2 && state <= 2) {
			this.state = state;
			return true;
		}
		else
			return false;
	}
}
