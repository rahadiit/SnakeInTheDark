package snake.map.types;

import snake.engine.settings.WorldSettings;
import snake.map.MapEntity;
import snake.visuals.Lights;
import snake.visuals.ShadowSource;
import snake.visuals.Shadows;
import snake.visuals.VisualGameWorld;
import box2dLight.ConeLight;
import box2dLight.Light;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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

public class TempleMap_test extends VisualGameWorld {
	
	// The code below is simply a prototype for testing purposes 
	private Sprite temple;
	private Sprite magician; //must be changed to Map Entities 
	private Sprite box;
	Light light;
	ShadowSource shadow;
	private float velocity = .2f;
	private int x = 1;
	private boolean y = false, triggered = false;
	
	public TempleMap_test (String LevelData/* Add other parameters of choice*/) {
		WorldSettings.setAmbientColor(Color.WHITE);
		
		Texture texture = new Texture(Gdx.files.internal("pixelArtTemple.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		temple = new Sprite(texture);
		temple.setSize(WorldSettings.getWorldWidth(), WorldSettings.getWorldHeight());
		
		Texture texture2 = new Texture(Gdx.files.internal("magician.png"));
		magician = new Sprite(texture2);
		magician.setSize(20, 20);
		magician.setAlpha(1f);
		magician.setPosition(40, WorldSettings.heightFix(30));
		magician.setOrigin(10, 11);
		
		Texture texture3 = new Texture(Gdx.files.internal("mysteryBox.png"));
		box = new Sprite(texture3);
		box.setSize(23, 23);
		box.setPosition(38, WorldSettings.heightFix(53));
		box.setAlpha(1f);
	}
	
	
	
	@Override
	public void act(float delta) {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			magician.setPosition(magician.getX() - .3f, magician.getY());
			light.setPosition(light.getX()- .3f , light.getY());
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			magician.setPosition(magician.getX() + .3f, magician.getY());
			light.setPosition(light.getX()+ .3f , light.getY());
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			magician.setPosition(magician.getX(), magician.getY() + .3f);
			light.setPosition(light.getX() , light.getY() + .3f);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			magician.setPosition(magician.getX(), magician.getY()- .3f);
			light.setPosition(light.getX() , light.getY() - .3f);
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
			WorldSettings.setAmbientColor(new Color (.1f, .1f, .3f, 1f));
		}
		if (Gdx.input.isKeyPressed(Input.Keys.X)) {
			WorldSettings.setAmbientColor(Color.WHITE);
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.C)) {
			magician.rotate(5);
			light.setDirection(90 + magician.getRotation());
		}
		if (Gdx.input.isKeyPressed(Input.Keys.V)) {
			magician.rotate(-5);
			light.setDirection(90 + magician.getRotation());
		}
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		temple.draw(batch);
		magician.draw(batch);
		box.draw(batch);
	}
	

	public void createLights() {
		light = new ConeLight (Lights.getRayhandler(), 5000, new Color(1f, 1f, .5f, 1f), 100, 50, WorldSettings.heightFix(50), 90, 30);
		
		shadow = Shadows.createRectShadowSource(15, 15, 50, WorldSettings.heightFix(70));
	}
	
	@Override
	public void dispose() {
		temple.getTexture().dispose();
		//light.dispose();
		temple.getTexture().dispose();
	}

}
