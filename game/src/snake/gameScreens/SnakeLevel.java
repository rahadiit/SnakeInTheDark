package snake.gameScreens;

import snake.core.SnakeStart;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class SnakeLevel implements Screen{

	private Game game;
	private SpriteBatch batch;
	private BitmapFont font;
	private float w, h;
	String instruction, instruction2;
	
	
	
	
	public SnakeLevel (Game game, SpriteBatch batch) {
		this.game = game;
		this.batch = batch;
		
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
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
