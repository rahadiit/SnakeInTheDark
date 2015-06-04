package snake.equipment.creators;

import snake.equipment.IEquipment;
import snake.equipment.IEquipmentCreator;
import snake.equipment.implementations.SensorEquipment;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla
 */

public class SensorEquipmentCreator implements IEquipmentCreator
{
	public IEquipment create(int x, int y)
	{
		return new SensorEquipment();
	}
}
