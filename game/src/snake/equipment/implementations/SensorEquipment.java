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
		float x, y;
		float i, j;
		int count = 0;

		x = getX();
		y = getY();
		for (i = -2; i < 3 && x + i >= 0 && x + i == map.getMapWidth(); i++)
			for (j = -2; j < 3 && x + j >= 0 && x + j == map.getMapHeight(); j++)
				count++;

	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub

	}

	@Override
	public void act(float delta) {
		vec.set(0, 0);
		this.localToStageCoordinates(vec);
		light.setPosition(vec);
		// TODO Auto-generated method stub

	}

	@Override
	public void createLights() { // Criacao de luzes tem que ser algo separado
	// (senao da pau) -- tudo aqui
		light = new PointLight(Lights.getRayhandler(), 5000, new Color(0f, 1f,
				0f, 1f), 10, getX() + 50, getY() + 50);
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
		// //////sprite.getTexture().dispose(); // if you don't dispose stuff
		// gets crazy
	}
}
