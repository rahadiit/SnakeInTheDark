package snake.equipment;

import snake.map.IMapAccess;

public interface IEquipment 
{
	public void activate(IMapAccess map);
	public String getDescription();
	public String getName();
}
