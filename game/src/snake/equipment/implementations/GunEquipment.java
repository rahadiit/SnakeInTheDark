package snake.equipment.implementations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import snake.engine.dataManagment.Loader;
import snake.map.IMapAccess;

/**
 * Developed By: NoDarkGlasses
 * 
 * @author Bszazulla & Gabriel Gimenez
 */

public class GunEquipment extends AbstractEquipment {
	
	boolean onMap;
	Texture texture;
	Sprite sprite;
	private int ammo;

	public GunEquipment(float x, float y, boolean onMap) {
		this.setBounds(x, y, 1, 1);
		this.onMap = onMap;
		this.name = "Gun";
		this.description = "When a droid gets close to you, if you have ammo, it's destroyed";

		Loader.load("equipments/BulletPixel.png", Texture.class);
		Loader.finishLoadingAsset("equipments/BulletPixel.png");
		texture = Loader.get("equipments/BulletPixel.png");
		sprite = new Sprite(texture);
		
		this.ammo = 3; // valor de inicio

	}

	public void activateOnMap(IMapAccess map) {
		// sem implement específico
	}

	@Override
	public void dispose() 
	{
		super.dispose(); // da o dispose da classe abstrata (veja la)
	
		Loader.unload("equipments/BulletPixel.png");
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		if (onMap)
			batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(),
					getWidth(), getHeight(), getScaleX(), getScaleY(),
					getRotation());
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub

	}
	public void setOnMap(boolean onMap){
		this.onMap = onMap;
	}
	
	public boolean getOnMap(){
		return this.onMap;
	}
	
	// quantidade de balas
	public int getAmmo()
	{
		return ammo;
	}

	public int shoot()
	{
		return --ammo;
	}
	
	public void addAmmo()
	{
		this.ammo++;
	}

	// THIS EQUIPMENT HAS NO LIGHTS
}
