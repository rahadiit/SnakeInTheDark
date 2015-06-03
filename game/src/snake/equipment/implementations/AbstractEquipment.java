package snake.equipment.implementations;


import snake.equipment.IEquipment;
import snake.map.IMapAccess;
import snake.visuals.enhanced.LightMapEntity;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla
 */

public abstract class AbstractEquipment extends LightMapEntity implements IEquipment
{
	protected String name;
	protected String description;
	
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public abstract void activate(IMapAccess map);

	@Override
	public boolean hasLights()
	{
		return false;
	}

	@Override
	public void createLights()
	{
	}

	@Override
	public void disposeLights()
	{
	}
}
