
package snake.drone;

import snake.engine.dataManagment.Loader;
import snake.engine.models.GameWorld;
import snake.player.Player;
import snake.visuals.enhanced.LightMapEntity;
import snake.map.CellType;
import snake.map.IMapAccess;
import snake.map.IMapEntity;
import snake.map.TiledMapWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
/**                              Developed By:
 *                                  NoDark
 *                               sessaGlasses
 *                               
 * 
 * 
 * @author Gus & Guilherme Higa
 */

public class Drone extends LightMapEntity implements IObserver{
	
	private TextureRegion tex;
	private String Direction;
	private String texName = "character/drone";
	private static Player player;
	private IMapAccess world;
	private static final int FRAME_ROWS_EXPLODE = 2, FRAME_COLS_EXPLODE = 6;
	private float explosionSpeed = 3f;
	private Texture explodeSheet;
	private TextureRegion region, currentFrame;
	private Animation explodeAnimation;
	private String explodeTexName = "character/explosaosprite.png";
	
	private float stateTime = 0;
	public Drone (GameWorld world, int x, int y, String Direcao){
		super(world);
		
		this.world = ((TiledMapWorld) world).getMapAccess();
		
		this.setSize(5f, 6);
		this.setOrigin(x,y); 
		
		//Observer
		player = Player.getInstance(world);
		player.attach(this);
		
		if(Direcao.equalsIgnoreCase("esquerda"))
			texName = texName + "esquerda.png";
		
		else if(Direcao.equalsIgnoreCase("direita"))
			texName = texName + "direita.png";
		
		else if(Direcao.equalsIgnoreCase("cima"))
			texName = texName + "tras.png";
		
		else if(Direcao.equalsIgnoreCase("baixo"))
			texName = texName + "frente.png";
		
		
		Loader.load(texName,Texture.class);
		Loader.getManager().finishLoadingAsset(texName);
		
		tex = Loader.get(texName);	
		//sprite.setAlpha(1f);

		this.Direction = Direcao;	
		
		//carrega spirte da explosao
		Loader.load(explodeTexName, Texture.class);
		Loader.finishLoadingAsset(explodeTexName);
		explodeSheet = Loader.get(explodeTexName);
		
		
		TextureRegion[][] tmp2 = region.split(region.getRegionWidth()/FRAME_COLS_EXPLODE, region.getRegionHeight()/FRAME_ROWS_EXPLODE);
		explodeAnimation = new Animation(explosionSpeed, tmp2[0]);
		
	}
	
	public void update(float delta){
		if(Direction.equalsIgnoreCase("Esquerda") && !CellType.WALL.equals(world.getCellType((int)getX() - 1, (int)getY())))
			moveBy(-2.5f,0);
			
		else if(Direction.equalsIgnoreCase("Direita") && !CellType.WALL.equals(world.getCellType((int)getX() + 1, (int)getY())))
			moveBy(2.5f,0);
		
		else if(Direction.equalsIgnoreCase("Cima") && !CellType.WALL.equals(world.getCellType((int)getX(), (int)getY() + 1)))
			moveBy(0,2.5f);
		
		else if(Direction.equalsIgnoreCase("Baixo") && !CellType.WALL.equals(world.getCellType((int)getX(), (int)getY() - 1)))
			moveBy(0,-2.5f);
		else{
			//Ativar animacao
			stateTime+= delta;
			tex = explodeAnimation.getKeyFrame(stateTime, true);
			
			this.dispose();
		}
	}

	@Override
	public void draw (Batch batch, float parentAlpha) { //Aqui se desenha
		
		batch.draw(tex, getX(), getY(), getOriginX(), getOriginY(), //Esse tanto de parametro e necessario para movimento automatico
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

	@Override
	public String getType() {
		return "Drone";
	}


}
