package snake.equipment.creators;

import snake.equipment.IEquipment;
import snake.equipment.IEquipmentCreator;
import snake.equipment.implementations.GunEquipment;
import snake.map.IMapAccess;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla & Gabriel Gimenez
 */

public class GunEquipmentCreator implements IEquipmentCreator
{
	public IEquipment create(float x, float y, boolean onMap, IMapAccess access)
	{
		return new GunEquipment(x, y, onMap);
	}
}
