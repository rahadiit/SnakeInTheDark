package snake.equipment.creators;

import snake.equipment.IEquipment;
import snake.equipment.IEquipmentCreator;
import snake.equipment.implementations.SensorEquipment;
import snake.map.IMapAccess;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla & Gabriel Gimenez
 */

public class SensorEquipmentCreator implements IEquipmentCreator
{
	public IEquipment create(float x, float y, boolean onMap, IMapAccess access)
	{
		return new SensorEquipment(x, y, onMap, access);
	}
}
