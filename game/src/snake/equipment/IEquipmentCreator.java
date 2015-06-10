package snake.equipment;

import snake.map.IMapAccess;

public interface IEquipmentCreator
{
	IEquipment create(float x, float y, boolean onMap, IMapAccess access);
}
