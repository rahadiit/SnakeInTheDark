package snake.tests;

import java.util.ArrayList;
import java.util.List;
import snake.Drone.IObserver;
import snake.engine.dataManagment.Loader;
import snake.engine.models.GameWorld;
import snake.visuals.enhanced.LightMapEntity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**                              Developed By:
 *                                  NoDark
 *                               sessaGlasses
 *                               
 * <br> Player for testing purposes at TempleMap </br>
 * 
 * @author Mr.Strings & Guilherme Higa
 */

public class Player extends LightMapEntity {
	
	//Singleton area
	private static Player player;
	
	private static final int DOWN = 0, LEFT = 1, RIGHT = 2, UP = 3;
	private static final int ANIMATION_WALK_STATES_NUM = 4, ANIMATION_STILL_STATES_NUM = 3;
	
	private enum State {STANDING, MOVING};
	
	//Animation
	private Texture walkSheet, standingSheet; //debugar o esquema
	private Animation[] animatedWalk, animatedStanding;
	private TextureRegion currentFrame, region;
	private String walkTexName = "character/CharacterSprite.png", standingTexName = "character/BlinkingCharacterSprite.png";
	
	private static final int FRAME_ROWS_WALK = 4, FRAME_COLS_WALK = 3;
	private static final int FRAME_ROWS_STANDING = 3, FRAME_COLS_STANDING = 3;
	
	private float speed = 10;
	private int direction = UP;
	private State state = State.STANDING;
	private Animation currentAnimation;
	
	//Equipments
	private Weapon weapon;
	private FlashLight_test flashlight;
	
	//Stuff
	private int timer = 0;
	private float stateTime = 0;

	private List<IObserver> observers = new ArrayList<IObserver>();
	
	private Player (GameWorld world) {
		super(world);

		this.setSize(1f, 1f);
		this.setOrigin(0,0); // A origem ficou zoada pois o PNG nao ficou bom -- arrumar isso
		
		//Procedimento padrao para se carregar um arquivo (FORMA EFICIENTE!!)
		Loader.load(walkTexName, Texture.class);
		Loader.finishLoadingAsset(walkTexName);
		walkSheet = Loader.get(walkTexName);
		
		Loader.load(standingTexName, Texture.class);
		Loader.finishLoadingAsset(standingTexName);
		walkSheet = Loader.get(standingTexName);
		
		
		
		//Cria as animacoes
		animatedWalk = new Animation[4];
	    for (int i = 0; i < ANIMATION_WALK_STATES_NUM; i++) {

	    	region = new TextureRegion(walkSheet, 0, (float) i/FRAME_ROWS_WALK, 1,(float) (i+1) /FRAME_ROWS_WALK);
	    	
			TextureRegion[][] tmp2 = region.split(region.getRegionWidth()/FRAME_COLS_WALK,region.getRegionHeight());
			
			animatedWalk[i] = new Animation(0.25f, tmp2[0]);
	    }
	    
	    animatedStanding = new Animation[4];
	    for (int i = 0; i < ANIMATION_STILL_STATES_NUM; i++) {

	    	region = new TextureRegion(walkSheet, 0, (float) i/FRAME_ROWS_STANDING, 1,(float) (i+1) /FRAME_ROWS_STANDING);
	    	
			TextureRegion[][] tmp2 = region.split(region.getRegionWidth()/FRAME_COLS_STANDING,region.getRegionHeight());
			
			animatedStanding[i] = new Animation(0.25f, tmp2[0]);
	    }
	    
	    currentAnimation = animatedStanding[DOWN];
	    

		//adiciona equipamento lanterna_teste
		flashlight = new FlashLight_test (world);
		this.addActor(flashlight);
		flashlight.setPosition(0,0);		
	}
	
	static public Player getinstance(GameWorld world){
		if(player == null)
			player = new Player(world);
		return player;
	}
	
	@Override
	public void act (float delta) { // Aqui se realizam as atualizacoes
		super.act(delta);
		timer++;
		
		
		stateTime += delta;
		currentFrame = currentAnimation.getKeyFrame(stateTime, true);
		
		
		if (state  == State.STANDING) {
			
			timer = 6;
			if(timer>5){
				timer = 0;
			
				if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
					moveBy(-speed * delta, 0);
					direction = LEFT;
					update();
				}
				else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
					moveBy(speed * delta, 0);
					direction = RIGHT;
					update();
				}
				else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
					moveBy(0, speed * delta);
					direction = UP;
					update();
				}
				else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
					moveBy(0, -speed * delta);
					direction = DOWN;
					update();
				}
				
				else if (Gdx.input.isKeyPressed(Input.Keys.C)) {
					rotateBy(5);
				}
				else if (Gdx.input.isKeyPressed(Input.Keys.V)) {
					rotateBy(-5);
				}										
			}
		}
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) { //Aqui se desenha
		
		
		batch.draw(currentFrame, getX(), getY(), getOriginX(), getOriginY(), //Esse tanto de parametro e necessario para movimento automatico
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
		Loader.unload(walkTexName);
		Loader.unload(standingTexName);
		player = null;
	}
	
	public void attach(IObserver observer){
	      observers.add(observer);		
	   }
	
	private void update(){
		for (IObserver observer : observers) {
			observer.update();
		}
	}
}
