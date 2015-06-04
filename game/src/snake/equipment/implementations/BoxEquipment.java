package snake.equipment.implementations;

import snake.map.IMapAccess;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author 
 */

public class SensorEquipment extends AbstractEquipment
{
	public BoxEquipment()
	{		
		this.name = "Box";
		this.description = "It would't be a Spy game without a box";	
	}
	
	public void activate(IMapAccess map) 
	{					
		map.Status("box")
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