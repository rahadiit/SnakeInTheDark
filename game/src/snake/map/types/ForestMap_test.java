package snake.map.types;

import snake.engine.settings.WorldSettings;
import snake.visuals.Lights;
import snake.visuals.VisualGameWorld;
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

public class ForestMap_test extends VisualGameWorld {
	
	// The code below is simply a prototype for testing purposes 
	private Sprite sprite;
	private Sprite entity; //must be changed to Map Entities 
	Light light;
	private float velocity = .2f;
	private int x = 1;
	private boolean y = false, triggered = false;
	
	public ForestMap_test (String LevelData/* Add other parameters of choice*/) {
		
		WorldSettings.setAmbientColor(Color.WHITE);
		
		Texture texture = new Texture(Gdx.files.internal("foggy_forest_by_BrokenLens.jpeg"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		sprite = new Sprite(texture);
		sprite.setSize(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight());
		
		Texture texture2 = new Texture(Gdx.files.internal("Scary_Silhouette.png"));
		entity = new Sprite(texture2);
		entity.setSize(4, 12);
		entity.setAlpha(1f);
		entity.setPosition(60, 15);
		
		
		
	}
	
	
	
	@Override
	public void act(float delta) {
		if (light.getX() >= 100) {
			velocity *=-1;
			y = false;
		} else if (light.getX() <= 0) {
			x++;
			if (x % 3 == 0) {
				y = true;
				entity.setPosition(entity.getX() - entity.getWidth()*1/2, entity.getY() - entity.getHeight()*3 /4);
				entity.setSize(entity.getWidth()* 2f, entity.getHeight() * 2f);
			}
			velocity *= -1;
		}
		light.setPosition(light.getX() + velocity, light.getY());
		
		
		if (x == 9 && light.getX() >= 90) {
			triggered = true;
			WorldSettings.setAmbientColor(new Color(1f, 0, 0, 1f));
		}
		
		if (triggered && light.getX() > 91) {
			Gdx.app.exit();
		}
		
		
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		sprite.draw(batch);
		
		if (y)
			entity.draw(batch);
	}
	

	public void createLights() {
		light = new PointLight (Lights.getRayhandler(), 5000, new Color(1f, 0f, .5f, 1f), 40, 50, WorldSettings.heightFix(50));
		light.setSoft(false);
	}
	
	@Override
	public void dispose() {
		sprite.getTexture().dispose();
		light.dispose();
		entity.getTexture().dispose();
	}

}
