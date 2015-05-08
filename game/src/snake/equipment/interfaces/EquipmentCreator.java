package snake.equipment.interfaces;

import snake.equipment.creators.FlashlightEquipmentCreator;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla
 */

public class EquipmentCreator
{
	
	public static IEquipmentCreator createFactory(String equipment)
	{
		// Aqui tem que definir os equipamentos e escolher as instâncias
		
		IEquipmentCreator obj = null;
		
		if(equipment.equalsIgnoreCase("flashlight"))
		{
			obj = new FlashlightEquipmentCreator();
		}
		
		return obj;
	}
}
