package snake.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import snake.engine.models.GameWorld;
import snake.visuals.enhanced.LightMapEntity;

public class Weapon extends LightMapEntity {
	Sprite sprite;
	boolean charging = false;

	
	
	public Weapon (GameWorld world) {
		super(world);
	}
	

	@Override
	public void act(float delta) {
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && charging == false) { //Devia ser acionada pelo player
			charging = true;
			Vector2 vector = this.localToStageCoordinates(new Vector2(0, 0));
			Bullet bullet = new Bullet (world, vector.x, vector.y, this.getParent().getRotation() + 90);
			world.addActor(bullet);
		}
		else if (charging == true && !Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			charging = false;
		}
		
		
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) { //Aqui se desenha
	}
	
	@Override
	public boolean hasLights() {
		return true;
	}

	@Override
	public void dispose() {
		if (this.getParent() != null)
			this.remove();
	}

}
