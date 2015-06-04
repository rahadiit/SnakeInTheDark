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

	
	
	public Weapon (GameWorld world) {
		super(world);
	}
	

	@Override
	public void act(float delta) {
		if (Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT)) { //Devia ser acionada pelo player
			Vector2 vector = this.localToStageCoordinates(new Vector2(0, 0));
			Bullet bullet = new Bullet (world, vector.x, vector.y, this.getParent().getRotation() + 90);
			if (bullet != null)
				world.addActor(bullet);
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
		this.remove();
	}

}
