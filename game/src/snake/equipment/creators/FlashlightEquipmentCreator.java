package snake.equipment.creators;

import snake.equipment.concreteImplementations.FlashlightEquipment;
import snake.equipment.interfaces.IEquipment;
import snake.equipment.interfaces.IEquipmentCreator;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla
 */

public class FlashlightEquipmentCreator implements IEquipmentCreator
{
	public IEquipment create()
	{
		return new FlashlightEquipment();
	}
}
