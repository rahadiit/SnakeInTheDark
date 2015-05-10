package snake.map;

import snake.engine.GameWorld;
import snake.engine.creators.WorldSettings;
import snake.engine.visuals.Lights;
import box2dLight.Light;
import box2dLight.PointLight;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;


/**                               Developed By:
 *                                   NoDark
 *                                sessaGlasses
 * Module: --------
 */

public class WorldMap extends GameWorld {
	
	// The code below is simply a prototype for testing purposes 
	private Texture texture;
	private Sprite sprite;
	Light light;
	private float i = .2f;
	
	public WorldMap (/* Add other parameters of choice*/) {
		
		texture = new Texture(Gdx.files.internal("foggy_forest_by_BrokenLens.jpeg"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite = new Sprite(texture);
		sprite.setSize(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight());
		
	}
	
	
	
	@Override
	public void act(float delta) {
		if (light.getX() >= 100 || light.getX() <= 0)
			i *=-1;
		light.setPosition(light.getX() + i, light.getY());
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		sprite.draw(batch);
	}
	
	@Override
	public void createLights() {
		light = new PointLight (Lights.getRayhandler(), 30, new Color(1f, 0f, .5f, 1f), 40, 50, WorldSettings.heightFix(50));
	}
	
	@Override
	public void dispose() {
		texture.dispose();
		light.dispose();
	}

}
