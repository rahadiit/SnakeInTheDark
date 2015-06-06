package snake.equipment.implementations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import snake.map.IMapAccess;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author 
 */

public class EmpEquipment extends AbstractEquipment
{
	Texture texture = new Texture(Gdx.files.internal("emp.png"));
	Sprite sprite = new Sprite(texture); 
	boolean onMap;
	public EmpEquipment()
	{		
		this.name = "EMP";
		this.description = "The EMP destroys every drone around you";
		this.setSize (4, 4); // tamanho defaut		
		this.onMap = onMap; //Hein?? O que eh isso? (se nao for um parametro do construtor, nao vale nada)
	}
	
	public void activateOnMap(IMapAccess map) 
	{
//		int x, y, i, j, m, n, a, b;
//		x = map.getX();
//		y = map.getY();
//		m = map.getWidth();
//		n = map.getHeight();
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
//					map.destroyDrone(i, j);
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
		if(onMap)
			batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}

	@Override
	public void act(float delta)
	{
		// TODO Auto-generated method stub

	}

	// THIS EQUIPMENT HAS NO LIGHTS
}
