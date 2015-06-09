package snake.equipment.implementations;

import snake.map.IMapAccess;
import snake.visuals.Lights;
import box2dLight.PointLight;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Developed By: NoDarkGlasses
 *
 * Implementação concreta do sensor
 * 
 * @author Gabriel Gimenez & Bszazulla
 */

public class SensorEquipment extends AbstractEquipment {

	// sensor eh um equipment sem sprite, ele eh fixo com o player
	PointLight light;
	Vector2 vec = new Vector2();
	boolean onMap = false;

	private static final float MIN_INTENSITY = .6f;
	private static final float MAX_INTENSITY = .9f;
	private static final float PULSE_VELOCITY = 3f;

	public SensorEquipment(float x, float y, boolean onMap) {
		this.name = "Sensor";
		this.description = "The Sensor reveals drones around you";
		this.setBounds(x, y, 1, 1); // ver o setPosition
	}

	public SensorEquipment() {
		this.name = "Sensor";
		this.description = "The Sensor reveals drones around you";
	}

	public void activateOnMap(IMapAccess map) {
	}

	public int hasDrone(IMapAccess map, int x, int y) {
		int count = 0;
		int radius = (int) 1f;
		for (int i = -radius; i <= radius && x + i >= 0 && x + i <= map.getMapWidth(); i += 1f )
			for (int j = -radius; j <= x+ radius && y + radius >= 0 && y + j <= map.getMapHeight(); j += 1f)
				if (map.getEntity(i, j).getType() == "Drone")
					count++;
		return count;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
	}

	private float time;

	@Override
	public void act(float delta) {
		vec.set(0, 0);
		this.localToStageCoordinates(vec);
		light.setPosition(vec);
		boolean drone;
		time += delta;
		float intensity = (MAX_INTENSITY - MIN_INTENSITY)
				* MathUtils.cos(PULSE_VELOCITY * time) + MIN_INTENSITY;

		light.setDistance(intensity);
		drone = false;
		if (hasDrone((IMapAccess) getWorld(), (int)getX(), (int)getY()) > 0) {
			light.setColor(new Color(1f, 0f, 0f, 1f));
			drone = true;
	}
		//BlinkingSensor.act(delta, drone);

	}

	@Override
	public void createLights() { // Criacao de luzes tem que ser algo separado
		// (senao da pau) -- tudo aqui
		light = new PointLight(Lights.getRayhandler(), 5000, new Color(0f, 1f,
				0f, 1f), MAX_INTENSITY, getX(), getY());
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
	public void dispose() 
	{
		super.dispose(); // esse estah na classe AbstractEquipment, abra ela se tiver duvida
	}

	public void setOnMap(boolean onMap) {
		this.onMap = onMap;
	}

	public boolean getOnMap() {
		return this.onMap;
	}

}
