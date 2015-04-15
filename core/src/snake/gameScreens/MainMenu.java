package snake.gameScreens;

import snake.core.SnakeStart;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenu implements Screen {
	Game game;
	SpriteBatch batch;
	int vx = 0, vy = 0;
	
	
	public MainMenu (SnakeStart game) {
		this.game = game;
		batch = game.batch;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
//		Gdx.gl.glClearColor(1, 0, 1, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.enableBlending();
//		batch.begin();
//		batch.draw(sprite, i+= vi, j+= vj);
//
//		if (i >= Gdx.graphics.getWidth() - img.getWidth() || i <= 0)
//			vi *= -1;
//		if (j >=  Gdx.graphics.getHeight() - img.getHeight() || j <= 0)
//			vj *= -1;
//
//		batch.end();
		
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
