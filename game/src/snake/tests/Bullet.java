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
	private float angularVelocity = 0;
	private Sprite sprite;
	private String texName = "blueOrb.png";
	private Light light;
	Vector2 vec;
	
	public Bullet (Group group) {

		
		//Procedimento padrao para se carregar um arquivo (FORMA EFICIENTE!!)
		Loader.load(texName, Texture.class);
		while (!Loader.isLoaded(texName))
			Loader.update();
					
		Texture texture = Loader.get(texName);
		sprite = new Sprite(texture);
		
		this.setSize(5, 5);
		//this.setOrigin(2.5f, 2.5f);

		velocity = new Vector2(0,0);
		
		createLights();
	}
	
	@Override
	public void act(float delta) {
		this.moveBy(delta*velocity.x, delta * velocity.y);
		this.rotateBy(delta * angularVelocity);
		
		vec = this.localToStageCoordinates(new Vector2(this.getWidth()/2, this.getHeight()/2));
		light.setPosition(vec.x, vec.y);
		
		if (getX() < 0 || getX() > WorldSettings.getWorldWidth()
			|| getY() < 0 || getY() > WorldSettings.getWorldHeight())
			dispose();
		
		if (this.hit(this.getX(), this.getY(), true) != null) {
			this.dispose();
		}
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) {
		batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), //Esse tanto de parametro e necessario para movimento
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
	
	public void dispose () {
		super.dispose();
		if (this.getParent() != null || this.getStage() != null)
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
		
		//Mudança de coordenadas
		vec = this.localToStageCoordinates(new Vector2(this.getWidth()/2, this.getHeight()/2));
		light = new PointLight (Lights.getRayhandler(), 5000, new Color(.5f, .5f, 1, 1f), 5,
								vec.x, vec.y); //criacao de luz
		light.setSoft(false);
		
	}

	@Override
	public void disposeLights() {
		if (light != null) {
			light.remove();
			light.dispose();
			light = null;
		}
		
		super.disposeLights();
	}
	
	
	public void setVelocity (Vector2 velocity) {
		this.velocity.set(velocity);
	}
	
}
