package snake.equipment.core;

import snake.equipment.interfaces.IEquipment;
import snake.map.interfaces.IMapAccess;


/*                               Developed By:
 *                                  NoDarkGlasses
 *                        
 * Module: bszazulla && --------------- (modifiable according to need)
 */


public class FlashlightEquipment implements IEquipment
{
	private final String name = "Flashlight";
	private final String description = "The Flashlight lights all around you in an especific range. It helps you to avoid enemies, or to know where they aren't.";
	public final int range = 2; // raio de 2 casas, se fixo
	
	// ver se podem haver lanternas com ranges diferentes!
	
	public String getName()
	{
		return this.name;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public void activate(IMapAccess map)
	{
		// implementar isso!
	}
}
