package snake.gameScreens;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
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

public class SnakeLevel implements Screen{

	private SnakeStart game;
	private SpriteBatch batch;
	private InputMultiplexer input;
	private Camera camera;
	private BitmapFont font;
	private Stage stageWorld, stageHUD;
	private GameWorld world;      
	private HUD hud;
	private String congratz;
	
	
	public SnakeLevel (SnakeStart game,  String level) {
		this.game = game;
		this.batch = game.getBatch();
		
		//Creates GameWorld
		world = WorldSettings.createWorld (game, "Generic level");
		//Creates HUD
		hud = HUDSettings.createHUD(world);

		//Creates a stage (world organizer)
		stageWorld = new Stage(WorldSettings.createWorldViewport(world), batch);
		//Creates a stage (UI organizer)
		stageHUD = new Stage(HUDSettings.createHUDViewport(hud), batch);
		
		//Adds world and HUD to the stages
		stageWorld.addActor(world);
		stageHUD.addActor(hud);
		
		//stageWorld.getViewport().getCamera().translate(-WorldSettings.getWorldWidth()/2, -WorldSettings.getWorldHeight()/2, 0);
		
		
		/*camera = new OrthographicCamera(1280, 720);
		camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
		camera.translate(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 0);  // Going to the middle
		camera.update(); */
	}
	
	
	@Override
	public void show() {
		font = new BitmapFont(Gdx.files.internal("ak_sc_o.fnt"), false);
		font.setColor(Color.GREEN);
		congratz = new String ("Well done, you pressed it!");
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		stageWorld.draw();
        
        /*batch.setProjectionMatrix(camera.combined);
        batch.begin();
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
			font.draw(batch, "Now you're pressing the space button", 0, 80);
		font.draw(batch, congratz, 1280/2 - font.getBounds(congratz).width/2, 720/2 - font.getBounds(congratz).height/2 );
		batch.end(); */
	}
	

	@Override
	public void resize(int width, int height) {
		
		stageWorld.getViewport().update (width, height);
		//stageWorld.getViewport().getCamera().translate(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0);
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
	
	
	public Viewport getWorldViewport () {
		return stageWorld.getViewport();
	}
	
	public Viewport getHUDViewPort () {
		return stageHUD.getViewport();
	}
	

}
