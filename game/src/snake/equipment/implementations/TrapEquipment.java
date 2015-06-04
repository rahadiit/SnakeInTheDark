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
@Override
public void dispose()
{
	// TODO Auto-generated method stub

}

@Override
public void draw(Batch batch, float parentAlpha)
{
	// TODO Auto-generated method stub

}

@Override
public void act(float delta)
{
	// TODO Auto-generated method stub

}

// THIS EQUIPMENT HAS NO LIGHTS
}