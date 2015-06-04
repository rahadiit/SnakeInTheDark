package snake.equipment.implementations;

import box2dLight.ConeLight;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import snake.map.IMapAccess;
import snake.visuals.Lights;

/**                              Developed By:
 *                                  NoDarkGlasses
 *                                  
 * Implementação concreta da lanterna
 *                        
 * @author bszazulla
 */

public class FlashlightEquipment extends AbstractEquipment 
{
	Texture texture = new Texture(Gdx.files.internal("PixelFlashlight.png"));
	Sprite sprite = new Sprite(texture); 
	ConeLight light;
	int cont;

	// Construtor com parametros de posição de início
	public FlashlightEquipment(int x, int y)
	{
		this.name = "Flashlight";
		this.description = "The Flashlight...";
		
		this.setBounds(x, y, 5, 5); // ver o setPosition
	}
	
	// Construtor sem parâmetros
	public FlashlightEquipment()
	{
		this.name = "Flashlight";
		this.description = "The Flashlight...";
		
		this.setBounds(20, 20, 5, 5); // ver o setPosition do player!!!!!!!!
	}
	
	// Ativação de seu efeito no mapa
	public void activate(IMapAccess map) 
	{
		// implementar isso
	}

	// Desenho do equipamento no jogo, SE ADICIONADO EM ALGUM LUGAR QUE PEÇA SEU DRAW (EXEMPLO: MAPA TEMPLE)
	public void draw (Batch batch, float parentAlpha)
	{
		batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), 
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
	// Atualização gráfica no jogo
	public void act (float delta) 
	{
		// esses getters são relativos à imagem da lanterna, para que a luz fique sempre junto dela
		light.setPosition(getOriginX() + getX() + 3, getOriginY() + getY() + 3);
		light.setDirection(sprite.getRotation() + 90); 
		
		// luz deve acompanhar o player
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
	} // Se quiser destruir a luz, pode ser em qualquer lugar

	@Override
	public void disposeLights()
	{
		light.remove(); // IF you don't remove stuff gets crazy
		light.dispose();
	}
	
	@Override
	public void dispose() 
	{
		sprite.getTexture().dispose(); // if you don't dispose stuff gets crazy too
	}
}