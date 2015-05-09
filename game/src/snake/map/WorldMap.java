package snake.map;

import snake.engine.GameWorld;
import snake.engine.creators.WorldSettings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * Module: --------
 */

public class WorldMap extends GameWorld {
	
	// The code below is simply a prototype for testing purposes 
	private Texture texture;
	private Sprite sprite;
	DirectionalLight light;
	
	public WorldMap (/* Add other parameters of choice*/) {
		
		texture = new Texture(Gdx.files.internal("TorontoView.jpeg"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite = new Sprite(texture);
		sprite.setSize(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight());
		
		light = new DirectionalLight();
	}
	
	
	@Override
	public void act(float delta) {}
	
	@Override
	public void draw (Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		sprite.draw(batch);
	}
	
	@Override
	public void dispose() {
		texture.dispose();
	}

}
