package snake.equipmentComponent;

import snake.interfacesAndAbstract.IEquipment;
import snake.interfacesAndAbstract.IEquipmentCreator;


/*                               Developed By:
 *                                  NoDarkGlasses
 *                        
 * Module: bszazulla && --------------- (modifiable according to need)
 */


public class FlashlightEquipmentCreator implements IEquipmentCreator
{
	public IEquipment create()
	{
		return new FlashlightEquipment();
	}
}
