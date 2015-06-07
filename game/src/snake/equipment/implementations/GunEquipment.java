package snake.equipment.implementations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import snake.engine.dataManagment.Loader;
import snake.map.IMapAccess;

/**
 * Developed By: NoDarkGlasses
 * 
 * @author bszazulla
 */

public class GunEquipment extends AbstractEquipment
{
	boolean onMap;
	Texture texture;
	Sprite sprite; 
	public GunEquipment(float x, float y, boolean onMap)
	{
		this.setBounds(x, y, 4, 4);
		this.onMap = onMap; 
		this.name = "Gun";
		this.description = "When a droid gets close to you, if you have ammo, it's destroyed";
		
		Loader.load("equipments/BulletPixel.png", Texture.class);
		Loader.finishLoadingAsset("equipments/BulletPixel.png");
		texture = Loader.get("equipments/BulletPixel.png");
		sprite = new Sprite(texture);

	}

	public int ammo;

	public void activateOnMap(IMapAccess map) 
	{
		//if (ammo > 0)
		//	map.destroyDrone(map.getX(), map.getY());
	}

	@Override
	public void dispose()
	{
		Loader.unload("equipments/BulletPixel.png");
	}

	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		if(onMap)
			batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}

	@Override
	public void act(float delta)
	{
		// TODO Auto-generated method stub

	}

	// THIS EQUIPMENT HAS NO LIGHTS
}
