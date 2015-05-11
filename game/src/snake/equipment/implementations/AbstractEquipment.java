package snake.equipment.implementations;


import snake.equipment.IEquipment;
import snake.map.IMapAccess;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla
 */

public abstract class AbstractEquipment implements IEquipment
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
}
