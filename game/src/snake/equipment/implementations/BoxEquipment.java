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

public class BoxEquipment extends AbstractEquipment
{	
	boolean onMap;
	Texture texture = new Texture(Gdx.files.internal("mysteryBox.png"));
	Sprite sprite = new Sprite(texture); 
	public BoxEquipment()
	{		
		this.name = "Box";
		this.description = "It would't be a Spy game without a box";	
		this.setSize(4, 4); // tamanho defaut
		this.onMap = onMap; //Hein?? O que eh isso? (se nao for um parametro do construtor, nao vale nada) //Strings

	}
	
	public void activateOnMap(IMapAccess map) 
	{					
		//map.Status(box)
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
		if(onMap)
			batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}

	// THIS EQUIPMENT HAS NO LIGHTS
}
