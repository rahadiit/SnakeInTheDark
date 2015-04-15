package snake.gameScreens;

import java.util.ArrayList;
import java.util.Map;
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
import snake.interfacesAndAbstract.*;

/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings
 */

public class SnakeLevel implements Screen{

	public static float MAP_WIDTH, MAP_HEIGHT;
	private Game game;
	private SpriteBatch batch;
	private InputMultiplexer input;
	private Camera camera;
	private BitmapFont font;
	private Stage stageMap, StageUI;
	//private Map map;      //TO BE ADDED
	
	ArrayList<Drawable> drawSubscribers, updateSubscribers;// will be removed
	Map<Integer, Drawable> keySubscribers;// will be removed
	
	
	
	
	
	public SnakeLevel (Game game, SpriteBatch batch) {
		this.game = game;
		this.batch = batch;
		
		camera = new OrthographicCamera();
		
		MAP_WIDTH = Gdx.graphics.getWidth() * 2/3; //TESTING SIZES
		MAP_HEIGHT = Gdx.graphics.getHeight() * 2/3; //TESTING SIZES
	}
	
	
	@Override
	public void show() {
		font = new BitmapFont(Gdx.files.internal("ak_sc_o.fnt"), false);
		font.setColor(Color.GREEN);
	}

	@Override
	public void render(float delta) {
		
		String congratz = new String ("Well done, you pressed it!");
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
			font.draw(batch, "Now you're pressing the space button", 0, 80);
		font.draw(batch, congratz, 1280/2 - font.getBounds(congratz).width/2, 720/2 - font.getBounds(congratz).height/2 );
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}
	
	

}
