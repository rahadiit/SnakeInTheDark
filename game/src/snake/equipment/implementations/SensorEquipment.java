package snake.equipment.implementations;

import box2dLight.PointLight;
import box2dLight.PositionalLight;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import snake.map.IMapAccess;
import snake.visuals.Lights;

/**
 * Developed By: NoDarkGlasses
 *
 * Implementa������o concreta do sensor
 * 
 * @author bszazulla
 */

public class SensorEquipment extends AbstractEquipment {

	// sensor eh um equipment sem sprite, ele eh fixo com o player
	PointLight light;
	Vector2 vec = new Vector2();

	public SensorEquipment(float x, float y, boolean onMap) {
		this.name = "Sensor";
		this.description = "The Sensor reveals drones around you";
		this.setBounds(x, y, 5, 5); // ver o setPosition
	}

	public SensorEquipment() {
		this.name = "Sensor";
		this.description = "The Sensor reveals drones around you";
	}

	public void activateOnMap(IMapAccess map) {
	}

	int a = 0;
//	public int hasDrone(int x, int y, int radius) {
//		int count = 0;
//		IMapAccess map;
//		for(int i = -radius; i <= radius && x + i >= 0 && x+i <= map.getMapWidth(); i++)
//			for (int j = -radius; j <= radius && x + j >= 0 && x+j <= map.getMapHeight(); j++)
//				if (map.getEntity(i, j).type == "DRONE")
//					count++;
//		return count;
//	}
	

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub

	}

	@Override
	public void act(float delta) {
		vec.set(0, 0);
		this.localToStageCoordinates(vec);
		light.setPosition(vec);

//		if (hasDrone((int)getX(), (int)getY(), 10) > 0)
	//	 	light.setColor(new Color(1f, 0f, 0f, 1f));

	}

	@Override
	public void createLights() { // Criacao de luzes tem que ser algo separado
		// (senao da pau) -- tudo aqui
		light = new PointLight(Lights.getRayhandler(), 5000, new Color(0f, 1f,
				0f, 1f), 10, getX(), getY());
		light.setActive(true);
	}

	@Override
	public void disposeLights() {
		if (light != null) {
			light.remove();
			light.dispose();
		}
	}

	@Override
	public void dispose() {
	}
}
