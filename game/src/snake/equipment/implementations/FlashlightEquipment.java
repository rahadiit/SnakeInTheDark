package snake.equipment.implementations;

import snake.drone.IObserver;
import snake.engine.dataManagment.Loader;
import snake.map.IMapAccess;
import snake.player.Player;
import snake.visuals.Lights;
import box2dLight.ConeLight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                                  
 * Implementacao concreta da lanterna
 *                        
 * @author bszazulla
 */

public class FlashlightEquipment extends AbstractEquipment implements IObserver
{
	Texture texture;
	Sprite sprite; 
	ConeLight light;
	Vector2 vec = new Vector2();
	boolean onMap;
	int cont;
	int batteryCounter;
	private String flashlightClickName = "sounds/flashlightClick.wav";
	Sound flashlightClick;

	// Construtor com parametros de posicao de inicio
	public FlashlightEquipment(float x, float y, boolean onMap)
	{
		this.name = "Flashlight";
		this.description = "The Flashlight lights in front of you, but use with caution, it doesn't last long.";
		this.setBounds(x, y, 1, 1); // tamanho default
		this.onMap = onMap;		
		
		Loader.load("equipments/PixelFlashlight.png", Texture.class);
		Loader.finishLoadingAsset("equipments/PixelFlashlight.png");
		texture = Loader.get("equipments/PixelFlashlight.png");
		sprite = new Sprite(texture);
		
		this.batteryCounter = 5; // bateria fixa de toda lanterna
		
		// flashlight sound 
		Loader.load(flashlightClickName, Sound.class);
		Loader.finishLoadingAsset(flashlightClickName);
		flashlightClick = Loader.get(flashlightClickName);
	}

	// Ativacao de seu efeito no mapa
	public void activateOnMap(IMapAccess map)
	{
		// nao ha ativacao especifica para a lanterna
	}

	// Desenho do equipamento no jogo, SE ADICIONADO EM ALGUM LUGAR QUE PECA SEU
	public void draw(Batch batch, float parentAlpha)
	{
		// se estiver no mapa eh que usa a sprite
		if (onMap)
			batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(),
					getScaleY(), getRotation());
	}

	// Atualizacao grafica no jogo 
	public void act(float delta)
	{
		// arruma a posicao do foco de luz
		vec.set(.45f, 0);
		this.localToStageCoordinates(vec);
		light.setPosition(vec);

		// aurruma a rotacao do foco de luz
		Actor parent = this.getParent();
		float rotation = 0;
		while (parent != null)
		{
			rotation += parent.getRotation();
			parent = parent.getParent();
		}

		// arruma a rotacao da propria lanterna
		this.setRotation(rotation);
		light.setDirection(rotation);

		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && (!onMap))
		{
			
			flashlightClick.play(.2f);
			light.setActive(!light.isActive());
			if (light.isActive())
				this.batteryCounter--;
			if(this.batteryCounter == 0)
				dispose();
		}

	}

	// THIS EQUIPMENT HAS LIGHTS
	@Override
	public boolean hasLights()
	{
		return true;
	}

	@Override
	public void createLights()
	{ // Criacao de luzes tem que ser algo separado (senao da pau) -- tudo aqui
		light = new ConeLight(Lights.getRayhandler(), 5000, new Color(1f, 1f, .5f, 1f), 2, getX(), getY(), 90, 30);
		light.setActive(false);
	} // Se quiser destruir a luz, pode ser em qualquer lugar

	@Override
	public void dispose()
	{
		super.dispose(); // esse estah na classe AbstractEquipment, abra ela se tiver duvida

		if(light != null)
		{
			light.remove();
			light.dispose();
		}
		
		Loader.unload("equipments/PixelFlashlight.png"); // da o unload
		Loader.unload(flashlightClickName);
	}

	public void setOnMap(boolean onMap)
	{
		this.onMap = onMap;
	}

	public boolean getOnMap()
	{
		return this.onMap;
	}
	
	@Override
	public void onPickup(Player player)
	{
		player.attach(this);
	}
	
	@Override
	public void update(float delta)
	{		
		if (light.isActive())
			this.batteryCounter--;
		if(this.batteryCounter == 0)
			dispose();

		// se acabar a bateria, a lanterna se da um dispose
	}
}
