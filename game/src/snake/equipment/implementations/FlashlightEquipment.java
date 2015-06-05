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
 * Implementa��o concreta da lanterna
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

	// Construtor com parametros de posi��o de in�cio
	public FlashlightEquipment(int x, int y)
	{
		this.name = "Flashlight";
		this.description = "The Flashlight lights in front of you, but use with caution, it doesnt last long";
		
		this.setBounds(x, y, 5, 5); // ver o setPosition
		vec = new Vector2();
	}
	
	// Construtor sem par�metros
	public FlashlightEquipment()
	{
		this.name = "Flashlight";
		this.description = "The Flashlight lights in front of you, but use with caution, it doesnt last long";
		
		this.setBounds(20, 20, 5, 5); // ver o setPosition do player!!!!!!!!
	}
	
	// Ativa��o de seu efeito no mapa
	public void activate(IMapAccess map) 
	{
		// implementar isso
	}

	// Desenho do equipamento no jogo, SE ADICIONADO EM ALGUM LUGAR QUE PE�A SEU DRAW (EXEMPLO: MAPA TEMPLE)
	public void draw (Batch batch, float parentAlpha)
	{
		batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), 
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
	// Atualiza��o gr�fica no jogo
	public void act (float delta) 
	{
		vec.set(0, 0);
		this.localToStageCoordinates(vec);

		if (Gdx.input.isKeyJustPressed(Input.Keys.SHIFT_LEFT))
		{
			System.out.println(getX() + ":" + getY());
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
		sprite.getTexture().dispose(); // if you don't dispose stuff gets crazy too
	}
}