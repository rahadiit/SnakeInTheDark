
package snake.Drone;

import snake.engine.dataManagment.Loader;
import snake.engine.models.GameWorld;
import snake.tests.Player;
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
 * @author Gus & Guilherme Higa
 */

public class Drone extends LightMapEntity implements IObserver{
	
	private Sprite sprite;
	private String Direction;
	private String texName = "character/dronefrente.png";
	private static Player player;

	public Drone (GameWorld world, int x, int y, String Direcao){
		super(world);
		
		this.setSize(5f, 6);
		this.setOrigin(x,y); //, valor dado por quem chama , mapa?
		
		player = Player.getinstance(world);
		player.attach(this);
		Loader.load(texName,Texture.class);
		Loader.getManager().finishLoadingAsset(texName);
		
		Texture texture = Loader.get(texName);
		sprite = new Sprite(texture);		
		//sprite.setAlpha(1f);

		this.Direction = Direcao;	
				
	}
	
	public void update(){
		if(Direction.equalsIgnoreCase("Esquerda"))
			moveBy(-2.5f,0);
			
		else if(Direction.equalsIgnoreCase("Direita"))
			moveBy(2.5f,0);
		
		else if(Direction.equalsIgnoreCase("Cima"))
			moveBy(0,2.5f);
		
		else if(Direction.equalsIgnoreCase("Baixo"))
			moveBy(0,-2.5f);

		}

	@Override
	public void draw (Batch batch, float parentAlpha) { //Aqui se desenha
		
		batch.draw(sprite, getX(), getY(), getOriginX(), getOriginY(), //Esse tanto de parametro e necessario para movimento automatico
				getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
		super.draw(batch, parentAlpha);
	}

	@Override
	public boolean hasLights() {
		return false;
	}

	@Override
	public void createLights() { //Criacao de luzes tem que ser algo separado (senao da pau) -- tudo aqui
		super.createLights(); //Importante para criar as luzes/sombra dos filhos
	}

	@Override
	public void disposeLights() {
		super.disposeLights();
	}

	@Override
	public void dispose() {
		super.dispose();
		if (this.getParent() != null || this.getStage() != null) {
			this.remove();
		}
		Loader.unload(texName);
	}
}
