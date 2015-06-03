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
 * @author bszazulla
 */

public class FlashlightEquipment extends AbstractEquipment 
{
	Texture texture = new Texture(Gdx.files.internal("flashlight.png"));
	Sprite sprite = new Sprite(texture); 
	ConeLight light;
	int cont;
	boolean acesa = true;
	
	public FlashlightEquipment()
	{
		this.name = "Flashlight";
		this.description = "The Flashlight...";
		
		this.setBounds(20, 20, 5, 5); // ver o setPosition
	}
	
	public void activate(IMapAccess map) 
	{
		// implementar isso
	}
	
	// DESENHA NO MAPA -> ELE FAZ ISSO SOZINHO FORA COM A SPRITE QUE É GUARDADA AQUI
	public void draw (Batch batch, float parentAlpha)
	{
		batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), 
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
	}
	
	// FAZ PARTE DA ATUALIZAÇÃO DA LÓGICA DO JOGO -- SE NÃO TEM LUZ 
	public void act (float delta) 
	{
		light.setPosition(getOriginX() + getX() + 4, getOriginY() + getY() + 3);
		light.setDirection(sprite.getRotation() + 45); // atualiza de acordo com a rotação da imagem do objeto
		
		cont++;
		if(cont%60 == 0)
		{
			if(acesa)
			{
				light.remove();
				acesa = false;
			}
			else
			{
				light.add(Lights.getRayhandler());
				acesa = true;
			}
		}
		
		// transformaçao de coordenadas para mexer junto com o player quando for junto com o player
		
		
	}

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
}