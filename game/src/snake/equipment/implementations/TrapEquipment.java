package snake.equipment.implementations;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import snake.map.IMapAccess;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla
 */

public class TrapEquipment extends AbstractEquipment
{
	Texture texture = new Texture(Gdx.files.internal("equipments/ArmadilhaDesarmada.png"));
	Sprite sprite = new Sprite(texture); 
	boolean onMap;

	public TrapEquipment(float x, float y, boolean onMap)
	{		
		this.name = "Trap";
		this.description = "The Trap destroy a drone that pass the cell you placed it";	
		this.setBounds(x, y, 4, 4);
		this.onMap = onMap; 
	}
	
	public void activateOnMap(IMapAccess map) 
	{
		//map.setCell(map.getx(), map.gety(), trap);
	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Batch batch, float parentAlpha)
	{
		batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), 
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}

	@Override
	public void act(float delta)
	{
		// TODO Auto-generated method stub

	}

	// THIS EQUIPMENT HAS NO LIGHTS
}