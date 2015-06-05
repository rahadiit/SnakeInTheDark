package snake.tests;

import snake.engine.dataManagment.Loader;
import snake.engine.models.GameWorld;
import snake.visuals.enhanced.LightMapEntity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Weapon extends LightMapEntity {
	private boolean charging = false;
	private Vector2 vec;
	private Bullet bullet;
	private float bulletSize, MAXSIZE = 3, MINSIZE = .4f;
	private String shootSoundName = "spark.mp3", thunderSoundName = "thunder.mp3";
	Sound shootSound, thunderSound;

	
	
	public Weapon (GameWorld world) {
		super(world);
		vec = new Vector2 ();
		
		this.setSize(5, 5);
		this.setOrigin(2.5f,  2.5f);
		
		Loader.load(shootSoundName, Sound.class);
		Loader.load(thunderSoundName, Sound.class);
		while (!Loader.isLoaded(shootSoundName) || !Loader.isLoaded(thunderSoundName))
			Loader.update();
		shootSound = Loader.get(shootSoundName);
		thunderSound = Loader.get(thunderSoundName);
	}
	

	@Override
	public void act(float delta) {
		super.act(delta);
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && !charging) { //Devia ser acionada pelo player
			charging = true;
			bullet = new Bullet (world);
			bullet.setPosition(0, 0);
			this.addActor(bullet);
			
			bulletSize = MINSIZE;
			bullet.setScale(bulletSize);
			bulletSize += (.5f * delta);
		}
		else if (charging && Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			if (bulletSize <= MAXSIZE) {
				bullet.setScale(bulletSize);
				bulletSize += (2f * delta);
			}
		}

		else if (charging && !Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			charging = false;
			
			bullet.remove();
			
			//set position
			vec.set(0,0);
			this.localToStageCoordinates(vec);
			bullet.setPosition(vec.x, vec.y);

			//set velocity 
			vec.set(0,40);
			
			//Must rotate vector according to world
			float rotation = 0;
			Actor parent = this.getParent();
			while (parent != null) {
				rotation += parent.getRotation();
				parent = parent.getParent();
			}
			vec.rotate(rotation);
			bullet.setVelocity(vec);
			
			//add to weapon
			world.addActor(bullet);
			
			bullet.setZIndex(1);; //make it go under the box
			
			if (bulletSize < 2f)
				shootSound.play(.5f);
			else
				thunderSound.play(.5f);
		}
		
		
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) { //Aqui se desenha
		super.draw(batch, parentAlpha);
	}
	
	@Override
	public boolean hasLights() {
		return true;
	}

	@Override
	public void dispose() {
		if (this.getParent() != null)
			this.remove();
		Loader.unload(shootSoundName);
	}

}
