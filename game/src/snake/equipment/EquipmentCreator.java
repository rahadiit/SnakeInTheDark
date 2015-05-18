package snake.equipment;

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
		// Aqui tem que definir os equipamentos e escolher as instancias
		
		IEquipmentCreator obj = null;
		
		switch (equipment.toLowerCase())
		{
			case "flashlight":
				obj = new FlashlightEquipmentCreator();
				break;
			case "sensor":
				obj = new SensorEquipmentCreator();
				break;
			default:
				throw new IllegalArgumentException(String.format("No factory defined for \"%s\".", equipment));
		}
		
		return obj;
	}
}
