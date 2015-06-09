package snake.equipment.implementations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import snake.engine.dataManagment.Loader;
import snake.map.IMapAccess;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla & Gabriel Gimenez
 */

public class BoxEquipment extends AbstractEquipment
{	
	boolean onMap;
	Texture texture;
	Sprite sprite;
	public BoxEquipment(float x, float y, boolean onMap)
	{		
		this.name = "Box";
		this.description = "It would't be a Spy game without a box";	
		this.setBounds(x, y, 1, 1); // tamanho default
		this.onMap = onMap;
		
		Loader.load("equipments/BoxPixel.png", Texture.class);
		Loader.finishLoadingAsset("equipments/BoxPixel.png");
		texture = Loader.get("equipments/BoxPixel.png");
		sprite = new Sprite(texture);

	}
	
	public void activateOnMap(IMapAccess map) 
	{					
		//map.Status(box)
	}

	@Override
	public void dispose()
	{
		Loader.unload("equipments/BoxPixel.png");

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
	public void setOnMap(boolean onMap){
		this.onMap = onMap;
	}
	
	public boolean getOnMap(){
		return this.onMap;
	}


	// THIS EQUIPMENT HAS NO LIGHTS
}
