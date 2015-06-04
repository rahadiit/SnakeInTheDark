package snake.equipment.implementations;

import snake.map.IMapAccess;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla
 */

public class TrapEquipment extends AbstractEquipment
{
	public TrapEquipment()
	{		
		this.name = "Trap";
		this.description = "The Trap destroy a drone that pass the cell you placed it";	
	}
	
	public void activate(IMapAccess map) 
	{
		map.setCell(map.getx(), map.gety(), trap);
	}
}