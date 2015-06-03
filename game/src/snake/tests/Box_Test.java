package snake.tests;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import snake.engine.creators.WorldSettings;
import snake.engine.dataManagment.Loader;
import snake.engine.models.GameWorld;
import snake.visuals.ShadowSource;
import snake.visuals.Shadows;
import snake.visuals.enhanced.LightMapEntity;

public class Box_Test extends LightMapEntity{
	private Sprite sprite;
	private ShadowSource shadow;
	private String texName = "mysteryBox.png";
	
	public Box_Test(GameWorld world) {
		super(world);
			
		world.addActor(this);
		//Procedimento padrao para se carregar um arquivo (FORMA EFICIENTE!!)
		Loader.load(texName, Texture.class);
		while (!Loader.isLoaded(texName))
			Loader.update();
								
		//Cria a imagem
		Texture texture = Loader.get(texName);
		sprite = new Sprite(texture);
		
		this.setBounds(38, WorldSettings.heightFix(53), 23, 23);
		sprite.setAlpha(1f);
		
		this.setPosition(38, WorldSettings.heightFix(53));
	}
	
	@Override
	public void act(float delta) {}
	
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
	public void createLights() {
		shadow = Shadows.createRectShadowSource(15, 15, 50, WorldSettings.heightFix(70));
	}
	
	public void disposeLights() {
		shadow.destroyShadow();
	}

	@Override
	public void dispose() {
		Loader.unload(texName);
	}
}
