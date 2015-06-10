package snake.equipment.creators;

import snake.equipment.IEquipment;
import snake.equipment.IEquipmentCreator;
import snake.equipment.implementations.BoxEquipment;
import snake.map.IMapAccess;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla & Gabriel Gimenez
 */

public class BoxEquipmentCreator implements IEquipmentCreator
{
	public IEquipment create(float x, float y, boolean onMap, IMapAccess access)
	{
		return new BoxEquipment(x, y, onMap);
	}
}
