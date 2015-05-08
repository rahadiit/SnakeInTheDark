package snake.equipment.interfaces;

import snake.map.interfaces.IMapAccess;

public interface IEquipment 
{
	public void activate(IMapAccess map);
	public String getDescription();
	public String getName();
}
