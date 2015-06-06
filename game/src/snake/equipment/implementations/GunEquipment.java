package snake.equipment.implementations;

import com.badlogic.gdx.graphics.g2d.Batch;

import snake.map.IMapAccess;

/**
 * Developed By: NoDarkGlasses
 * 
 * @author bszazulla
 */

public class GunEquipment extends AbstractEquipment
{
	boolean onMap;
	Texture texture = new Texture(Gdx.files.internal("PixelFlashlight.png"));
	Sprite sprite = new Sprite(texture); 
	public GunEquipment()
	{
		this.name = "Gun";
		this.description = "When a droid gets close to you, if you have ammo, it's destroyed";
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
		// TODO Auto-generated method stub

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
