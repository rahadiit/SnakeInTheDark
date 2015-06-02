package snake.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;
import snake.engine.models.GameWorld;
import snake.visuals.enhanced.LightMapEntity;

public class Weapon extends LightMapEntity{
	GameWorld world;
	Sprite sprite;
	
	
	public Weapon (GameWorld world, Group group, float x, float y, float rotation) {
		this.world = world;
		group.addActor(this);
		
		Texture texture = new Texture (Gdx.files.internal("bullet.png"));
		sprite = new Sprite(texture);
		sprite.setAlpha(1f); //Transparencia -- de 0 a 1 (0 eh invisivel
		
		this.setBounds(0, 0, 20, 20);
		this.setRotation(rotation);
	}
	

	@Override
	public void act(float delta) {
		if (Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT)) {
			Bullet bullet = new Bullet (this, this.getX(), this.getY(), this.getRotation());
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.Q))
			this.getParent().rotateBy(1);
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) { //Aqui se desenha
		batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), //Esse tanto de parametro e necessario para movimento
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
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
