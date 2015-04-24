package snake.gameScreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import snake.core.SnakeStart;
import snake.interfacesAndAbstract.*;
import snake.levelSettings.HUDSettings;
import snake.levelSettings.WorldSettings;
import snake.map.WorldMap;

/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings
 */

public class SnakeLevel implements Screen {

	private SnakeStart game;
	private SpriteBatch batch;
	private InputMultiplexer input;
	private BitmapFont font;
	private Stage stageWorld, stageHUD;
	private GameWorld world;
	private HUD hud;

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

		// stageWorld.getViewport().getCamera().translate(-WorldSettings.getWorldWidth()/2,
		// -WorldSettings.getWorldHeight()/2, 0);
		input = new InputMultiplexer();
		// input.addProcessor(stageWorld./*Something()*/);
		// input.addProcessor(stageHUD./*Something()*/);

	}
	
	public Viewport getWorldViewport() {return stageWorld.getViewport();}

	public Viewport getHUDViewPort() {return stageHUD.getViewport();}

	public GameWorld getGameWorld() {return world;}
	
	public HUD getHUD() {return hud;}

	
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

		stageWorld.draw();
		stageHUD.draw();

		/*
		 * batch.setProjectionMatrix(camera.combined); batch.begin(); if
		 * (Gdx.input.isKeyPressed(Input.Keys.SPACE)) font.draw(batch,
		 * "Now you're pressing the space button", 0, 80); font.draw(batch,
		 * congratz, 1280/2 - font.getBounds(congratz).width/2, 720/2 -
		 * font.getBounds(congratz).height/2 ); batch.end();
		 */
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
}
