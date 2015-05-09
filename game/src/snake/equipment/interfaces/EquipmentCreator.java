package snake.equipment.interfaces;

import snake.equipment.creators.FlashlightEquipmentCreator;
import snake.equipment.creators.SensorEquipmentCreator;

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
		else if(equipment.equalsIgnoreCase("sensor"))
		{
			obj = new SensorEquipmentCreator();
		}
		
		return obj;
	}
}
