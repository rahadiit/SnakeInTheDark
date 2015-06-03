package snake.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import snake.engine.dataManagment.Loader;
import snake.engine.models.GameWorld;
import snake.visuals.enhanced.LightMapEntity;

public class Weapon extends LightMapEntity{
	GameWorld world;
	Sprite sprite;
	String texName = "bullet.png";
	
	
	public Weapon (GameWorld world) {
		this.world = world;
		
		//Procedimento padrao para se carregar um arquivo (FORMA EFICIENTE!!)
		Loader.load(texName, Texture.class);
		while (!Loader.isLoaded(texName))
			Loader.update();
		
		//Cria a imagem
		Texture texture = Loader.get(texName);
		sprite = new Sprite(texture);
	}
	

	@Override
	public void act(float delta) {
		if (Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT)) { //Devia ser acionada pelo player
			Vector2 vector = this.localToStageCoordinates(new Vector2(0, 0));
			Bullet bullet = new Bullet (world, vector.x, vector.y, this.getParent().getRotation() + 90);
			world.addActor(bullet);
		}
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
	public void dispose() {
		Loader.unload(texName);
	}

}
