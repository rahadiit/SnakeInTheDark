package snake.equipment.implementations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import snake.engine.dataManagment.Loader;
import snake.map.IMapAccess;

/**
 * Developed By: NoDarkGlasses
 * 
 * @author bszazulla & Gabriel Gimenez
 */

public class EmpEquipment extends AbstractEquipment {
	Texture texture;
	Sprite sprite;
	boolean onMap;

	public EmpEquipment(float x, float y, boolean onMap) {
		this.name = "EMP";
		this.description = "The EMP destroys every drone around you";
		this.setBounds(x, y, 1, 1); // tamanho default
		this.onMap = onMap;

		Loader.load("equipments/emp.png", Texture.class);
		Loader.finishLoadingAsset("equipments/emp.png");
		texture = Loader.get("equipments/emp.png");
		sprite = new Sprite(texture);

	}

	public void activateOnMap(IMapAccess map) {
		int x = (int)getX();
		int y = (int)getY();
		int i, j, radius = (int) 2f;
		for (i = -radius; i <= radius && x + i >= 0
				&& x + i <= map.getMapWidth(); i += 1f)
			for (j = -radius; j <= x+ radius && y + radius >= 0
					&& y + j <= map.getMapHeight(); j += 1f)
				if (map.getEntity(i, j).getType() == "Drone")
					map.removeEntity(map.getEntity(i, j));
	}

	@Override
	public void dispose() 
	{
		super.dispose(); // da o dipose de luzes e afins
		
		Loader.unload("equipments/emp.png"); // da o dispose da sprite
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		if (onMap)
			batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(),
					getWidth(), getHeight(), getScaleX(), getScaleY(),
					getRotation());
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub

	}
	public void setOnMap(boolean onMap){
		this.onMap = onMap;
	}
	
	public boolean getOnMap(){
		return this.onMap;
	}


	// THIS EQUIPMENT HAS NO LIGHTS
}
