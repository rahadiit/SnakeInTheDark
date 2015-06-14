
package snake.drone;

import snake.engine.dataManagment.Loader;
import snake.player.Player;
import snake.visuals.Lights;
import snake.visuals.enhanced.LightMapEntity;
import snake.map.CellType;
import snake.map.IMapAccess;
import snake.map.IMapEntity;
import box2dLight.PointLight;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**                              Developed By:
 *                                  NoDark
 *                               sessaGlasses
 *                               
 * 
 * 
 * @author Gus & Guilherme Higa
 */

public class Drone extends LightMapEntity implements IObserver{
	
	private enum State {MOVING, STANDING, EXPLODING};
	
	private TextureRegion tex;
	private TextureRegion[] explodeFrames;
	private Vector2 direction;
	private String texName = "character/drone", explodeTexName = "character/explosaosprite.png";
	private static Player player;
	private IMapAccess world;
	private static final int FRAME_ROWS_EXPLODE = 2, FRAME_COLS_EXPLODE = 6;
	private float explosionSpeed = .1f;
	private Texture explodeSheet;
	private TextureRegion region, currentFrame;
	private Animation explodeAnimation;
	private float speed = 3f;
	private State state = State.STANDING;
	PointLight light;
	Vector2 vec = new Vector2();
	
	
	//Stuff
	private float time;
	private float distanceMoved;
	private float lastPosX, lastPosY;
	
	
	private float stateTime = 0;
	public Drone (IMapAccess world, int x, int y, String direcao){
		
		this.world = world;
		
		this.setSize(1, 1);
		this.setPosition(x,y);
		
		//Observer
		player = Player.getCurrentInstance();
		player.attach(this);
		
		if(direcao.equalsIgnoreCase("esquerda")) {
			this.direction = new Vector2(-speed, 0);
			texName = texName + "esquerda.png";
		}
		
		else if(direcao.equalsIgnoreCase("direita")) {
			this.direction = new Vector2(speed, 0);
			texName = texName + "direita.png";
		}
		
		else if(direcao.equalsIgnoreCase("cima")) {
			this.direction = new Vector2(0, speed);
			texName = texName + "tras.png";
		}
		
		else if(direcao.equalsIgnoreCase("baixo")) {
			this.direction = new Vector2(0, -speed);
			texName = texName + "frente.png";
		}
		
		
		Loader.load(texName,Texture.class);
		Loader.getManager().finishLoadingAsset(texName);
		
		tex = new TextureRegion ((Texture)Loader.get(texName));
		
		//carrega spirte da explosao
		Loader.load(explodeTexName, Texture.class);
		Loader.finishLoadingAsset(explodeTexName);
		explodeSheet = Loader.get(explodeTexName);
		
		
		TextureRegion[][] tmp = TextureRegion.split(explodeSheet, explodeSheet.getWidth()/FRAME_COLS_EXPLODE,
														explodeSheet.getHeight()/FRAME_ROWS_EXPLODE);
		
		explodeFrames = new TextureRegion[FRAME_COLS_EXPLODE * FRAME_ROWS_EXPLODE];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS_EXPLODE; i++) {
            for (int j = 0; j < FRAME_COLS_EXPLODE; j++) {
                explodeFrames[index++] = tmp[i][j];
            }
        }
		explodeAnimation = new Animation(explosionSpeed, explodeFrames);
		
	}
	
	public void update(float delta){
		
		if(direction.x < 0) {
			if ((CellType.WALL.equals(world.getCellType((int)getX() - 1, (int)getY())) 
					|| (CellType.TRAP.equals(world.getCellType((int)getX() - 1, (int)getY()))))
					&& state != State.EXPLODING) {
				state = State.EXPLODING;
				time = 0;
			}
			else {
				IMapEntity entity = world.getEntity((int)getX() - 1, (int)getY(), "player");
				if (entity != null) {
					Vector2 v = ((Player) entity).getDirection();
					if (v.x == -direction.x && v.y == -direction.y) {
						if (((Player) entity).destroy()) {
							//TODO: GAME OVER
						}
						else {
							destroy();
						}
					}
				} 
				else if (state != State.EXPLODING){
					state = State.MOVING;
					lastPosX = getX();
					lastPosY = getY();
					distanceMoved = 0;
				}
			}
		}
			
			
		else if(direction.x > 0){
			if ((CellType.WALL.equals(world.getCellType((int)getX() + 1, (int)getY())) 
					|| (CellType.TRAP.equals(world.getCellType((int)getX() + 1, (int)getY()))))
					&& state != State.EXPLODING) {
				state = State.EXPLODING;
				time = 0;
			}
			else {
				IMapEntity entity = world.getEntity((int)getX() + 1, (int)getY(), "player");
				if (entity != null) {
					Vector2 v = ((Player) entity).getDirection();
					if (v.x == -direction.x && v.y == -direction.y) {
						if (((Player) entity).destroy()) {
							//TODO: GAME OVER
						}
						else {
							destroy();
						}
					}
				}
				else if (state != State.EXPLODING) {
					state = State.MOVING;
					lastPosX = getX();
					lastPosY = getY();
					distanceMoved = 0;
				}
			}
		}
		
		
		else if(direction.y > 0) {
			if ((CellType.WALL.equals(world.getCellType((int)getX(), (int)getY() + 1)) 
					|| (CellType.TRAP.equals(world.getCellType((int)getX(), (int)getY() + 1)))) 
					&& state != State.EXPLODING){
				destroy();
			}
			else {
				IMapEntity entity = world.getEntity((int)getX(), (int)getY() + 1, "player");
				if (entity != null) {
					Vector2 v = ((Player) entity).getDirection();
					if (v.x == -direction.x && v.y == -direction.y) {
						if (((Player) entity).destroy()) {
							//TODO: GAME OVER
						}
						else {
							destroy();
						}
					}
				}
				else if (state != State.EXPLODING){
					state = State.MOVING;
					lastPosX = getX();
					lastPosY = getY();
					distanceMoved = 0;
				}
			}
		}
		
		else if(direction.y < 0) {
			if ((CellType.WALL.equals(world.getCellType((int)getX(), (int)getY() - 1)) 
					|| (CellType.TRAP.equals(world.getCellType((int)getX(), (int)getY() - 1))))
					&& state != State.EXPLODING){
				state = State.EXPLODING;
				time = 0;
			}
			else {
				IMapEntity entity = world.getEntity((int)getX(), (int)getY() - 1, "player");
				if (entity != null) {
					Vector2 v = ((Player) entity).getDirection();
					if (v.x == -direction.x && v.y == -direction.y) {
						if (((Player) entity).destroy()) {
							//TODO: GAME OVER
						}
						else {
							destroy();
						}
					}
				}
				else if (state != State.EXPLODING){
					state = State.MOVING;
					lastPosX = getX();
					lastPosY = getY();
					distanceMoved = 0;
				}
			}
		}
	}
	
	
	private boolean notDisposed = true;
	@Override
	public void act(float delta) {
		vec.set(.5f, .5f);
		this.localToStageCoordinates(vec);
		light.setPosition(vec);
		
		if (state == State.MOVING) {
			distanceMoved += (speed * delta);
			if (distanceMoved == 1) {

				state = State.STANDING;
				stateTime = 0;
			}
			else if (distanceMoved > 1) { 
				lastPosX += (direction.x != 0 ? direction.x/Math.abs(direction.x) : 0);
				lastPosY += (direction.y != 0 ? direction.y/Math.abs(direction.y) : 0);
				this.setPosition(lastPosX, lastPosY);
				state = State.STANDING;
				stateTime = 0;
				
				IMapEntity entity = world.getEntity((int)getX(), (int)getY(), "player");
				if (entity != null) {
					if (((Player) entity).destroy()){
						//TODO: GAME OVER
					}
					else {
						destroy();
					}
				}
				
			}
			else {
				this.moveBy(direction.x * delta, direction.y * delta);
			}
		}	
		else if (state == State.EXPLODING) {
			tex = explodeAnimation.getKeyFrame(time);
			if (explodeAnimation.isAnimationFinished(time +=delta) && notDisposed) {
				this.dispose();
			}
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

	//@Override
	//public void createLights() { //Criacao de luzes tem que ser algo separado (senao da pau) -- tudo aqui
		//super.createLights(); //Importante para criar as luzes/sombra dos filhos
//	}

	@Override
	public void dispose() {
		notDisposed = false;
		super.dispose();
		if (this.getParent() != null || this.getStage() != null) {
			this.remove();
		}
		world.removeEntity(this);
		player.dettach(this);
		Loader.unload(explodeTexName);
		Loader.unload(texName);
		if (light != null)
		{
			light.remove();
			light.dispose();
		}

	}

	@Override
	public String getType() {
		return "Drone";
	}


	public boolean destroy() {
		state = State.EXPLODING;
		time = 0;
		light.setActive(true);
		return true;
	}
	
	public void createLights()
	{ // Criacao de luzes tem que ser algo separado
		// (senao da pau) -- tudo aqui
		light = new PointLight(Lights.getRayhandler(), 5000, Color.WHITE, 1, getX(), getY());
		light.setActive(false);
	}

}
