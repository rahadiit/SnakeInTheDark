package snake.equipment.implementations;

import box2dLight.PointLight;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import snake.engine.dataManagment.Loader;
import snake.map.IMapAccess;
import snake.map.IMapEntity;
import snake.visuals.Lights;

/**
 * Developed By: NoDarkGlasses
 *
 * Implementacao concreta do sensor
 * 
 * @author Gabriel Gimenez & Bszazulla
 */

public class SensorEquipment extends AbstractEquipment
{

	// sensor eh um equipment sem sprite, ele eh fixo com o player
	PointLight light;
	Vector2 vec = new Vector2();
	boolean onMap = false;
	IMapAccess access;
	private String sensorBackgroundName = "sounds/sensorBackground.mp3", sensorPingName = "sounds/sensorPing_cutShorter.mp3",
			endSensorName = "sounds/endSensor.wav";
	Sound sensorBackground, sensorPing, endSensor;

	private static final float MIN_INTENSITY = .6f;
	private static final float MAX_INTENSITY = .9f;
	private static final float PULSE_VELOCITY = 3f;

	public SensorEquipment(float x, float y, boolean onMap, IMapAccess access)
	{
		
		this.name = "Sensor";
		this.description = "The Sensor reveals drones around you";
		this.setBounds(x, y, 1, 1); // ver o setPosition
		this.access = access;

		// sensor sounds
		Loader.load(sensorBackgroundName, Sound.class);
		Loader.load(sensorPingName, Sound.class);
		Loader.load(endSensorName, Sound.class);
		Loader.finishLoadingAsset(sensorBackgroundName);
		Loader.finishLoadingAsset(sensorPingName);
		Loader.finishLoadingAsset(endSensorName);
		sensorBackground = Loader.get(sensorBackgroundName);
		sensorPing = Loader.get(sensorPingName);
		endSensor = Loader.get(endSensorName);
	}

	public void activateOnMap(IMapAccess map)
	{
	}

	public int hasDrone(int x, int y)
	{
		int count = 0;
		int radius = 1;
		for (int i = -radius; i <= radius; i++)
			for (int j = -radius; j <= radius; j++)
			{
				IMapEntity entity = access.getEntity(x + i, y + j, "Drone");
				if (entity != null)
					count++;
			}
		return count;
	}

	@Override
	public void draw(Batch batch, float parentAlpha)
	{
	}

	private float time;

	@Override
	public void act(float delta)
	{
		vec.set(0, 0);
		this.localToStageCoordinates(vec);
		light.setPosition(vec);
		time += delta;
		int drones = hasDrone((int) getParent().getX(), (int) getParent().getY());

		if (drones > 0)
		{
			light.setColor(Color.RED);
			float intensity = (MAX_INTENSITY - MIN_INTENSITY) * MathUtils.cos(PULSE_VELOCITY * time) + MIN_INTENSITY;
			light.setDistance(intensity);
			//sensorBackground.loop(1);
			sensorPing.loop(.1f, 1f, -1);
		}
		else
		{
			sensorBackground.stop();
			sensorPing.stop();

			// para o som do seensor terminar com um beep
			if (light.getColor().equals(Color.RED))
			{
				endSensor.play(.3f);
			}
			
			light.setDistance(MAX_INTENSITY);
			light.setColor(Color.WHITE);
		}
	}

	@Override
	public void createLights()
	{ // Criacao de luzes tem que ser algo separado
		// (senao da pau) -- tudo aqui
		light = new PointLight(Lights.getRayhandler(), 5000, new Color(0f, 1f, 0f, 1f), MAX_INTENSITY, getX(), getY());
		light.setActive(true);
	}

	@Override
	public void dispose()
	{
		if (light != null)
		{
			light.remove();
			light.dispose();
		}
		super.dispose(); // esse estah na classe AbstractEquipment, abra ela se
							// tiver duvida

		Loader.unload(sensorBackgroundName);
		Loader.unload(sensorPingName);
		Loader.unload(endSensorName);
	}

	public void setOnMap(boolean onMap)
	{
		this.onMap = onMap;
	}

	public boolean getOnMap()
	{
		return this.onMap;
	}

}
