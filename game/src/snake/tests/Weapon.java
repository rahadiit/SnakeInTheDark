package snake.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import snake.engine.models.GameWorld;
import snake.visuals.enhanced.LightMapEntity;

public class Weapon extends LightMapEntity{
	GameWorld world;
	
	
	public Weapon (GameWorld world, Group group, float x, float y, float rotation) {
		this.world = world;
		group.addActor(this);
		
		this.setBounds(0, 0, 20, 20);
		this.setRotation(rotation);
	}
	

	@Override
	public void act(float delta) {
		if (Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT)) { //Devia ser acionada pelo player
			Vector2 vector = this.localToStageCoordinates(new Vector2(this.getX() + 18, this.getY() + 15));
			Bullet bullet = new Bullet (world, vector.x, vector.y, this.getRotation());
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
	public void createLights() {}

	@Override
	public void disposeLights() {}

	@Override
	public void dispose() {}

}
