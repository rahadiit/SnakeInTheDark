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

	public GunEquipment()
	{
		this.name = "Gun";
		this.description = "When a droid gets close to you, if you have ammo, it's destroyed";
	}

	public int ammo;

	public void activateOnMap(IMapAccess map) 
	{
		//if (ammo > 0)
			
	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void act(float delta)
	{
		// TODO Auto-generated method stub

	}

	// THIS EQUIPMENT HAS NO LIGHTS
}