package snake.equipment.creators;

import snake.equipment.IEquipment;
import snake.equipment.IEquipmentCreator;
import snake.equipment.implementations.BoxEquipment;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla & Gabriel Gimenez
 */

public class BoxEquipmentCreator implements IEquipmentCreator
{
	public IEquipment create(float x, float y, boolean onMap)
	{
		return new BoxEquipment(x, y, onMap);
	}
}
