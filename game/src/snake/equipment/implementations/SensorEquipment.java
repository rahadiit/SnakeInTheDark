package snake.equipment.implementations;

import com.badlogic.gdx.graphics.g2d.Batch;
import snake.map.IMapAccess;

/**                              Developed By:
 *                                  NoDarkGlasses
 *
 * Implementação concreta do sensor
 *    
 * @author bszazulla
 */

public class SensorEquipment extends AbstractEquipment
{
	
	// sensor eh um equipment sem sprite, ele eh fixo com o player
	
	public SensorEquipment(int x, int y)
	{		
		this.name = "Sensor";
		this.description = "The Sensor...";
		
		this.setBounds(x, y, 5, 5); // ver o setPosition
	}
	
	
	public SensorEquipment()
	{		
		this.name = "Sensor";
		this.description = "The Sensor...";	
	}
	
	public void activate(IMapAccess map) 
	{
		// implementar isso!
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