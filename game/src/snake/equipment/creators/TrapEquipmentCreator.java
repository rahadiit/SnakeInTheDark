package snake.equipment.creators;

import snake.equipment.IEquipment;
import snake.equipment.IEquipmentCreator;
import snake.equipment.implementations.TrapEquipment;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla
 */

public class TrapEquipmentCreator implements IEquipmentCreator
{
	public IEquipment create(float x, float y)
	{
		return new TrapEquipment();
	}
}
