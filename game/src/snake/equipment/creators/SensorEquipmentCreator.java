package snake.equipment.creators;

import snake.equipment.implementations.SensorEquipment;
import snake.equipment.interfaces.IEquipment;
import snake.equipment.interfaces.IEquipmentCreator;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla
 */

public class SensorEquipmentCreator implements IEquipmentCreator
{
	public IEquipment create()
	{
		return new SensorEquipment();
	}
}
