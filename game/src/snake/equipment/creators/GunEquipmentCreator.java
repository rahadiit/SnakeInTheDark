package snake.equipment.creators;

import snake.equipment.IEquipment;
import snake.equipment.IEquipmentCreator;
import snake.equipment.implementations.GunEquipment;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla
 */

public class GunEquipmentCreator implements IEquipmentCreator
{
	public IEquipment create(float x, float y)
	{
		return new GunEquipment();
	}
}
