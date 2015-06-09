package snake.equipment.implementations;

import box2dLight.ConeLight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import snake.engine.dataManagment.Loader;
import snake.map.IMapAccess;
import snake.visuals.Lights;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                                  
 * Implementacao concreta da lanterna
 *                        
 * @author bszazulla
 */

public class FlashlightEquipment extends AbstractEquipment 
{
	Texture texture;
	Sprite sprite; 
	ConeLight light;
	Vector2 vec = new Vector2();
	boolean onMap;
	int cont;

	// Construtor com parametros de posicao de inicio
	public FlashlightEquipment(float x, float y, boolean onMap)
	{
		this.name = "Flashlight";
		this.description = "The Flashlight lights in front of you, but use with caution, it doesn't last long. To turn it on, press T button.";
		this.setBounds(x, y, 4, 4); // tamanho default
		this.onMap = onMap;		
		
		Loader.load("equipments/PixelFlashlight.png", Texture.class);
		Loader.finishLoadingAsset("equipments/PixelFlashlight.png");
		texture = Loader.get("equipments/PixelFlashlight.png");
		sprite = new Sprite(texture);

	}
	
	
	// Ativacao de seu efeito no mapa
	public void activateOnMap(IMapAccess map) 
	{
		// nao ha ativacao especifica para a lanterna
	}

	// Desenho do equipamento no jogo, SE ADICIONADO EM ALGUM LUGAR QUE PECA SEU SPRITE (EXEMPLO: MAPA TEMPLE)
	public void draw (Batch batch, float parentAlpha)
	{
		// se estiver no mapa eh que usa a sprite
		if(onMap)
			batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
	// Atualizacao grafica no jogo
	public void act (float delta) 
	{
		// set do vetor de localiza��o do foco de luz
		
		if (onMap)
			vec.set(2.3f, 3.6f); // ajustado a sprite PixelFlashlight.png, para ficar no lugar
		else
			vec.set(0, 0); // sen�o, centro defaut
		
		this.localToStageCoordinates(vec);
		
		// lanterna ascende ou apaga ao pressionar k
		if (Gdx.input.isKeyJustPressed(Input.Keys.T) && onMap == false)
		{
			light.setActive(!light.isActive());
		}

		light.setPosition(vec);

		Actor parent = getParent();
		if (parent != null)
			light.setDirection(parent.getRotation() + 90);
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
		light = new ConeLight(Lights.getRayhandler(), 5000, new Color(1f, 1f, .5f, 1f), 40, 45, 45, 45, 30);
		light.setActive(false);
	} // Se quiser destruir a luz, pode ser em qualquer lugar

	@Override
	public void disposeLights()
	{
		if (light != null)
		{
			light.remove();
			light.dispose();
		}
	}
	
	@Override
	public void dispose() 
	{
		Loader.unload("equipments/PixelFlashlight.png");
	}


	@Override
	public String getType() {
		return "Flashlight";
	}
}