package snake.equipment.implementations;

import box2dLight.ConeLight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

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
	Texture texture = new Texture(Gdx.files.internal("PixelFlashlight.png"));
	Sprite sprite = new Sprite(texture); 
	ConeLight light;
	Vector2 vec;
	int cont;
	boolean onMap;

	// Construtor com parametros de posicao de inicio
	public FlashlightEquipment(float x, float y, boolean onMap)
	{
		this.name = "Flashlight";
		this.description = "The Flashlight lights in front of you, but use with caution, it doesn't last long. To turn it on, press K button.";
		
		this.setBounds(x, y, 5, 5); // tamanho defaut
		vec = new Vector2();
		this.onMap = onMap;
	}
	
	// Construtor sem parï¿½metros
	public FlashlightEquipment(boolean onMap)
	{
		this.name = "Flashlight";
		this.description = "The Flashlight lights in front of you, but use with caution, it doesnt last long. To turn it on, press K button.";
		
		this.setBounds(20, 20, 5, 5); // ver o setPosition do player!!!!!!!!
		this.onMap = onMap;
	}
	
	// Ativacao de seu efeito no mapa
	public void activate(IMapAccess map) 
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
		// set do vetor de localização do foco de luz
		vec.set((float)2.8 , (float)3.7);
		this.localToStageCoordinates(vec);
		
		// lanterna ascende ou apaga ao pressionar k
		if (Gdx.input.isKeyJustPressed(Input.Keys.K))
		{
			light.setActive(!light.isActive());
		}

		light.setPosition(vec);
		light.setDirection(this.getParent().getRotation() + 90);
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
		sprite.getTexture().dispose(); // if you don't dispose stuff gets crazy
	}
}