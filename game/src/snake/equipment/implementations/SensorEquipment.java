package snake.equipment.implementations;

import snake.map.IMapAccess;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla
 */

public class SensorEquipment extends AbstractEquipment
{
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
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}