package snake.equipment.creators;

import snake.equipment.IEquipment;
import snake.equipment.IEquipmentCreator;
import snake.equipment.implementations.FlashlightEquipment;
import snake.map.IMapAccess;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla & Gabriel Gimenez
 */

public class FlashlightEquipmentCreator implements IEquipmentCreator
{
	public IEquipment create(float x, float y, boolean onMap, IMapAccess access)
	{
		return new FlashlightEquipment(x, y, onMap);
	}
}
