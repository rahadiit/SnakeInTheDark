package snake.equipment.implementations;

import com.badlogic.gdx.graphics.g2d.Batch;

import snake.map.IMapAccess;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author 
 */

public class BoxEquipment extends AbstractEquipment
{
	public BoxEquipment()
	{		
		this.name = "Box";
		this.description = "It would't be a Spy game without a box";	
	}
	
	public void activateOnMap(IMapAccess map) 
	{					
		//map.Status("box")
	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void act(float delta)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		// TODO Auto-generated method stub

	}

	// THIS EQUIPMENT HAS NO LIGHTS
}