package snake.tests;

import box2dLight.Light;
import box2dLight.PointLight;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import snake.engine.creators.WorldSettings;
import snake.engine.dataManagment.Loader;
import snake.engine.models.GameWorld;
import snake.visuals.Lights;
import snake.visuals.enhanced.LightMapEntity;

public class Bullet extends LightMapEntity {
	private Vector2 velocity;
	private float angularVelocity = 250;
	private Sprite sprite;
	private String texName = "demos/blueOrb.png";
	private Light light;
	Vector2 vec; //To avoid instantiating 60x per second
	
	public Bullet (GameWorld world) {
		super(world);
		velocity = new Vector2();
		vec = new Vector2();
		
		//Procedimento padrao para se carregar um arquivo (FORMA EFICIENTE!!)
		Loader.load(texName, Texture.class);
		Loader.load(texName, Texture.class);
		Loader.getManager().finishLoadingAsset(texName);
					
		Texture texture = Loader.get(texName);
		sprite = new Sprite(texture);
		
		this.setSize(5, 5);
		this.setOrigin(2.5f, 2.5f); //Note: To change origin, draw must be set also
		
		createLights();
	}
	
	@Override
	public void act(float delta) {
		this.moveBy(delta*velocity.x, delta * velocity.y);
		
		this.rotateBy(delta * angularVelocity);
		
		//Arruma a posicao da luz (Tem que ser relativa ao Stage
		vec.set(this.getWidth()/2 - getOriginX() , this.getHeight()/2 -getOriginY());
		this.setOrigin(0, 0);
		localToStageCoordinates(vec);
		this.setOrigin(2.5f, 2.5f);
		light.setPosition(vec.x, vec.y);
		light.setDistance(1.3f * Math.max(this.getWidth(), this.getHeight()) * Math.max(this.getScaleX(), this.getScaleY()));
		
		
		if (this.getParent() == getWorld() && 
				(vec.x < 0 || vec.x > WorldSettings.getWorldWidth()
			|| vec.y < 0 || vec.y > WorldSettings.getWorldHeight()))
			dispose(); 

	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) {//Repare que o draw esta diferente, para acomodar rotacao
		batch.draw(sprite, getX() - getOriginX(), getY() - getOriginY(), getOriginX(), getOriginY(), //Esse tanto de parametro e necessario para movimento
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
		vec.set(this.getWidth()/2 - getOriginX(), this.getHeight()/2 - getOriginY());
		localToStageCoordinates(vec);
		light = new PointLight (Lights.getRayhandler(), 5000, new Color(.5f, .5f, 1, 1f), 5,
								vec.x, vec.y); //criacao de luz
		light.setSoft(false);
		
	}
	
	public void setVelocity (Vector2 velocity) {
		this.velocity.set(velocity);
	}

	@Override
	public String getType() {
		return "bullet";
	}
	
	
}
