package snake.equipment.implementations;

import snake.map.IMapAccess;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla
 */

public class FlashlightEquipment extends AbstractEquipment 
{
	public FlashlightEquipment()
	{
		this.name = "Flashlight";
		this.description = "The Flashlight...";
	}
	public final int range = 2; // raio de 2 casas, se fixo
	
	public void activate(IMapAccess map) 
	{
		// implementar isso
	}
}