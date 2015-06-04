package snake.equipment.implementations;

import com.badlogic.gdx.graphics.g2d.Batch;
import snake.map.IMapAccess;

/**                              Developed By:
 *                                  NoDarkGlasses
 *
 * Implementa��o concreta do sensor
 *    
 * @author bszazulla
 */

public class SensorEquipment extends AbstractEquipment
{
	
	// sensor eh um equipment sem sprite, ele eh fixo com o player
	
	public SensorEquipment(int x, int y)
	{		
		this.name = "Sensor";
		this.description = "The Sensor reveals drones around you";
		
		this.setBounds(x, y, 5, 5); // ver o setPosition
	}
	
	
	public SensorEquipment()
	{		
		this.name = "Sensor";
		this.description = "The Sensor reveals drones around you";
	}
	
	public void activate(IMapAccess map) 
	{
		int x, y, i, j, m, n, a, b;
		x = map.getX();
		y = map.getY();
		m = map.getWidth();
		n = getHeight();
		
		if (x > 0)
			i = -1;
		else
			i = 0;
		if (y > 0)
			j = -1;
		
		else
			j = 0;
		
		if (x == m)
			a = 1;
		else
			a = 2;
		
		if (y == n)
			b = 1;
		else
			b = 2;

		for(i; i < a; i++)
			for (j; j < b; j++)
				if ()
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