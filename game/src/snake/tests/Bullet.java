package snake.tests;

import box2dLight.Light;
import box2dLight.PointLight;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import snake.engine.creators.WorldSettings;
import snake.engine.dataManagment.Loader;
import snake.visuals.Lights;
import snake.visuals.enhanced.LightMapEntity;

public class Bullet extends LightMapEntity {
	private Vector2 velocity;
	private Sprite sprite;
	private String texName = "blueOrb.png";
	private Light light;
	Vector2 vec;
	
	public Bullet (Group group, float x, float y, float rotation) {

		
		//Procedimento padrao para se carregar um arquivo (FORMA EFICIENTE!!)
		Loader.load(texName, Texture.class);
		while (!Loader.isLoaded(texName))
			Loader.update();
					
		Texture texture = Loader.get(texName);
		sprite = new Sprite(texture);
		
		this.setBounds(x, y, 5, 5);
		
		this.setRotation(rotation);
		
		velocity = new Vector2(1,0);
		velocity.rotate(rotation);
		
		createLights();
	}
	
	@Override
	public void act(float delta) {
		this.moveBy(velocity.x, velocity.y);
		
		vec = this.localToStageCoordinates(new Vector2(this.getWidth()/2, this.getHeight()/2));
		light.setPosition(vec.x, vec.y);
		
		if (getX() < 0 || getX() > WorldSettings.getWorldWidth()
			|| getY() < 0 || getY() > WorldSettings.getWorldHeight())
			dispose();
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) {
		batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), //Esse tanto de parametro e necessario para movimento
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
	
	public void dispose () {
		super.dispose();
		this.remove();
		Loader.unload(texName);
	}

	@Override
	public boolean hasLights() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createLights() {
		super.createLights();
		vec = this.localToStageCoordinates(new Vector2(this.getWidth()/2, this.getHeight()/2));
		light = new PointLight (Lights.getRayhandler(), 5000, new Color(.5f, .5f, 1, 1f), 5,
								vec.x, vec.y);
		light.setSoft(false);
		
	}

	@Override
	public void disposeLights() {
		light.remove();
		light.dispose();
		
		super.disposeLights();
	}
	
}
