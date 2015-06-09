package snake.equipment.implementations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import snake.engine.dataManagment.Loader;
import snake.map.IMapAccess;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                        
 * @author bszazulla
 */

public class TrapEquipment extends AbstractEquipment
{
	Texture texture;
	Sprite sprite; 
	boolean onMap;

	public TrapEquipment(float x, float y, boolean onMap)
	{		
		this.name = "Trap";
		this.description = "The Trap destroy a drone that pass the cell you placed it";	
		this.setBounds(x, y, 1, 1);
		this.onMap = onMap; 
		
		Loader.load("equipments/ArmadilhaDesarmada.png", Texture.class);
		Loader.finishLoadingAsset("equipments/ArmadilhaDesarmada.png");
		texture = Loader.get("equipments/ArmadilhaDesarmada.png");
		sprite = new Sprite(texture);

	}
	
	public void activateOnMap(IMapAccess map) 
	{
	//map.setCellType (int(getX()), int(getY()), "TRAP");
	}

	@Override
	public void dispose()
	{
		Loader.unload("equipments/ArmadilhaDesarmada.png");
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