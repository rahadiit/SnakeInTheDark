package snake.tests;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import snake.engine.creators.WorldSettings;
import snake.engine.dataManagment.Loader;
import snake.map.MapEntity;

public class Bullet extends MapEntity {
	private Vector2 velocity;
	private Sprite sprite;
	private String texName = "bullet.png";
	
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
		
	}
	
	@Override
	public void act(float delta) {
		this.moveBy(velocity.x, velocity.y);
		
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
		this.remove();
		Loader.unload(texName);
	}
	
}
