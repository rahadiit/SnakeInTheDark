package snake.map;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import snake.core.SnakeStart;
import snake.imageUtilities.CameraMan;
import snake.interfacesAndAbstract.GameWorld;
import snake.levelSettings.WorldSettings;


/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 * Module: --------
 */

public class WorldMap extends GameWorld {
	
	// The code below is simply a prototype for testing purposes 
	private Texture texture;
	private Sprite sprite;
	
	public WorldMap (/* Add other parameters of choice*/) {

		texture = new Texture(Gdx.files.internal("TorontoView.jpeg"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite = new Sprite(texture);
		sprite.setSize(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight());
	}
	
	
	@Override
	public void act(float delta) {
		getInput(delta);
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		sprite.draw(batch);
	}
	
	
	private void getInput (float delta) {
		
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
			CameraMan.moveCamera(this.getStage(), -20f * delta, 0);
		
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			CameraMan.moveCamera(this.getStage(), 20f * delta, 0);
		
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
			CameraMan.moveCamera(this.getStage(), 0, -20f * delta);
		if (Gdx.input.isKeyPressed(Input.Keys.UP))
			CameraMan.moveCamera(this.getStage(), 0, 20f * delta);
		
		if (Gdx.input.isKeyPressed(Input.Keys.O))
			CameraMan.zoomCamera(this.getStage(),-.5f * delta, -.5f * delta);
		
		if (Gdx.input.isKeyPressed(Input.Keys.P))
			CameraMan.zoomCamera(this.getStage(),.5f * delta, .5f * delta);
	}
	

}
