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
	ConeLight light;
	Vector2 vec = new Vector2();

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
	
	public void activateOnMap(IMapAccess map) 
	{
//		int x, y, i, j, m, n, a, b;
//		int count;
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
//				if (map.getCell(i, j) == "drone")
//					count++;
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
		vec.set(0, 0);
		this.localToStageCoordinates(vec);
		light.setActive(!light.isActive());
		light.setPosition(vec);

		// TODO Auto-generated method stub

	}
	
	@Override
	public void createLights()
	{ // Criacao de luzes tem que ser algo separado (senao da pau) -- tudo aqui
		light = new PointLight(Lights.getRayhandler(), 5000, new Color(1f, 1f, .5f, 1f), 40, 45, 45, 45, 30);
		light.setActive(false);
	} // Se quiser destruir a luz, pode ser em qualquer lugar

	@Override
	public void disposeLights()
	{
		if (light != null)
		{
			light.remove();
			light.dispose();
		}
	}
	
	@Override
	public void dispose() 
	{
		sprite.getTexture().dispose(); // if you don't dispose stuff gets crazy
	}
}
