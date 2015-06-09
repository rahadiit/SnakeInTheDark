package snake.equipment.creators;

import snake.equipment.IEquipment;
import snake.equipment.IEquipmentCreator;
import snake.equipment.implementations.SensorEquipment;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla & Gabriel Gimenez
 */

public class SensorEquipmentCreator implements IEquipmentCreator
{
	public IEquipment create(float x, float y, boolean onMap)
	{
		return new SensorEquipment(x, y, onMap);
	}
}
