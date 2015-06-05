package snake.equipment.implementations;

import com.badlogic.gdx.graphics.g2d.Batch;

import snake.map.IMapAccess;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author 
 */

public class EmpEquipment extends AbstractEquipment
{
	public EmpEquipment()
	{		
		this.name = "EMP";
		this.description = "The EMP destroys every drone around you";	
	}
	
	public void activateOnMap(IMapAccess map) 
	{
//		int x, y, i, j, m, n, a, b;
//		x = map.getX();
//		y = map.getY();
//		m = map.getWidth();
//		n = getHeight();
//		
//		if (x > 0)
//			i = -1;
//		else
//			i = 0;
//		if (y > 0)
//			j = -1;
//		
//		else
//			j = 0;
//		
//		if (x == m)
//			a = 1;
//		else
//			a = 2;
//		
//		if (y == n)
//			b = 1;
//		else
//			b = 2;
//
//		for(i; i < a; i++)
//			for (j; j < b; j++)
//				if ()
//					
//				
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