package snake.Drone;

import snake.engine.dataManagment.Loader;
import snake.engine.models.GameWorld;
import snake.visuals.enhanced.LightMapEntity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**                              Developed By:
 *                                  NoDark
 *                               sessaGlasses
 *                               
 * 
 * 
 * @author Gus
 */

public class Drone extends LightMapEntity {
	private Sprite sprite;
	private String Direction;
	private String textName = "character/Drone";
	
	public Drone (GameWorld world, int x, int y, String Direcao){
		super(world);
		world.addActor(this);
		this.setSize(2.5f,3);
		//this.setOrigin(), valor dado por quem chama , mapa?
		
		this.Direction = Direcao;	
		Loader.load(textName,Texture.class);
		sprite = new Sprite(texture);
		
		sprite.setAlpha();
	}
	
	public void act(){
		if(Direction.equalsIgnoreCase("Esquerda"))
			moveBy(-2.5f,0);
			
		else if(Direction.equalsIgnoreCase("Direita"))
			moveBy(2.5f,0);
		
		else if(Direction.equalsIgnoreCase("Cima"))
			moveBy(0,2.5f);
		
		else if(Direction.equalsIgnoreCase("Baixo"))
			moveBy(0,2.5f);
			
		}
		
	}
	
}
