package snake.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import snake.engine.models.GameWorld;
import snake.map.MapEntity;

public class Bullet extends MapEntity {
	private Vector2 velocity;
	private Sprite sprite;
	
	public Bullet (Group group, float f, float g, float h) {
		super(group);
		
		Texture texture = new Texture (Gdx.files.internal("bullet.png"));
		sprite = new Sprite(texture);
		
		this.setBounds(f, g, 5, 5);
		
		velocity = new Vector2(0,1);
		
	}
	
	@Override
	public void act(float delta) {
		this.moveBy(velocity.x, velocity.y);
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) {
		batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), //Esse tanto de parametro e necessario para movimento
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
	
	public void dispose () {
		sprite.getTexture().dispose();
	}
	
}
