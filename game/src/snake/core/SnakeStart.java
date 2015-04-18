package snake.core;

import snake.gameScreens.SnakeHub;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: Mr.Strings
 */

public class SnakeStart extends Game {
	public SpriteBatch batch;
	
	// Note: This will be deleted soon
	/*Texture img;
	Sprite sprite;
	OrthographicCamera camera;
	int i = 0, j = 0;
	int vi = 2, vj = 2; */
	
	public SpriteBatch getBatch () {return batch;}

	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new SnakeHub(this));
		
		// Yep, same thing with these
		/*img = new Texture("badlogic.jpg");
		camera = new OrthographicCamera(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);*/
	}

	@Override
	public void render () {
		super.render();
		
		
		// And these 
		/*Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.enableBlending();
		batch.begin();
		batch.draw(sprite, i+= vi, j+= vj);
		
		if (i >= Gdx.graphics.getWidth() - img.getWidth() || i <= 0)
			vi *= -1;
		if (j >=  Gdx.graphics.getHeight() - img.getHeight() || j <= 0)
			vj *= -1;
		
		batch.end();*/
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
